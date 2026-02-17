# Lamha 开发全流程 Design Doc（最大可复用 / GitHub 版本化）

> 目标：把 Lamha 从「设计-实现-验证-打包-发 Release」的完整闭环写成一份可复用的工程手册。
> 
> 受众：未来的你 / 任何接手的工程 agent（不需要上下文也能照做）。

---

## 0. TL;DR（黄金路径 / Golden Path）

**当你说“这个版本 OK”之后，最短交付路径：**

1. **锚定版本**：记录 commit（或打 tag）。
2. **装到真机**：用 ADB 安装该 commit 对应 APK。
3. **三屏验收**：Home / Gali / Leela **都在 Android 上现截**，确认可读性。
4. **产出 Release artifact**：`assembleRelease`（签名策略见下）。
5. **GitHub Release**：tag → release → 附 APK + notes。

---

## 1. 产品与体验不变项（设计约束）

### 1.1 核心概念：The Palace of Life
- **Gali（街巷）**：生存、实用、对话与语法。
- **Leela（宫廷）**：审美与精神层（诗、典故、解析、词源/隐喻）。

Lamha 的设计不是“课程列表”，而是“双翼对照”的叙事结构。

### 1.2 核心信息架构：Day → Street/Court
数据模型在 `LessonRepository` 中以静态方式驱动（后续可迁移至 JSON/DB）：
- `Lesson(id, dayTitle, street, court)`
- `StreetSection(title, dialogue[], vocabulary[], grammarGuides[])`
- `CourtSection(title, poemLines[], analysis, wordBreakdown[])`

**约定：** `DialogueLine.id / VocabItem.id / WordAnalysis.id` 与 `res/raw` 音频资源命名一致（见 §6）。

---

## 2. 代码结构与架构（当前形态）

### 2.1 技术栈
- Kotlin
- Jetpack Compose + Material3
- 音频：`MediaPlayer`
- 内容：静态 `LessonRepository`（硬编码）

### 2.2 页面导航
`MainActivity.kt` 内部使用简单 state 驱动：
- `Screen.Home`
- `Screen.LessonDetail(lesson)`

### 2.3 UI 切换：底部 Tab（必须稳定可测）
在 `LessonDetailScreen()`：
- `selectedTab = 0` → **Gali · गली**
- `selectedTab = 1` → **Leela · लीला**

**验收锚点（自动化/人工都用它）：**
- TopBar 标题必须包含：
  - `Gali · गली`
  - `Leela · लीला`

（我们后续用 `uiautomator dump` 直接 grep 这个字符串做“没截错页”的门禁。）

---

## 3. 设计系统（Design System）与可读性红线

### 3.1 字体约定
- 展示/标题：Eczar（衬线，适配天城文/诗歌氛围）
- 正文/说明：Lato（更高可读性）

实现点：`ui/theme/Type.kt`（Material Typography override）。

### 3.2 背景与 Scrim
- Gali：`bg_sandstone` + 轻 scrim 提升文字可读性。
- Leela：`bg_leela_combined`（含曼陀罗纹理）+ 黑色 scrim。

### 3.3 可读性红线（必须遵守）
**任何截图/Release 交付前必须通过：**
1) **Leela 的诗歌卡片、正文解析必须可读**（对比足够，不允许“白底黄字看不清”这种回归）。
2) 三屏截图都必须来自**真机 Android 现截**。

> 经验教训：不要“凭记忆/猜测”发截图。先确认你安装的是哪个 commit，且肉眼/门禁确认可读性。

---

## 4. 分支与版本策略（防止“版本乱套”）

### 4.1 分支约定（建议）
- `master`：永远可构建、可截图验收。
- 临时试验：用短生命周期分支（如 `exp/*`），但**通过验收的版本必须回到 master**。

### 4.2 Release 锚定规则
- **Release tag 必须指向“验收通过”的 commit**。
- Release notes 必须包含：
  - commit hash
  - 三屏截图（或至少能复现的截图路径/命名约定）
  - 已知问题与下一步

示例：
- `v0.1.0` → 指向 `0b47eca`（Leela 可读性 OK 的版本）

---

## 5. 构建与验证（ARM64 现实版）

### 5.1 构建命令
在 repo 根目录：

```bash
./gradlew :app:assembleDebug --no-daemon
./gradlew :app:assembleRelease --no-daemon
```

产物路径：
- Debug：`app/build/outputs/apk/debug/app-debug.apk`
- Release（当前）：`app/build/outputs/apk/release/app-release-unsigned.apk`

### 5.2 ARM64 友好验证门禁（JVM UI gate）
由于 ARM64 环境上部分截图/渲染链（尤其 aapt2-from-Maven / Paparazzi）容易踩坑，目前采用：
- **Robolectric** + include Android resources 的 unit tests 作为“最低限度 UI gate”。

实现点（已在 `app/build.gradle.kts` 体现）：
- `testOptions.unitTests.isIncludeAndroidResources = true`
- 依赖：`org.robolectric:robolectric`

> 目标不是替代真机验收，而是减少“明显 UI/资源挂掉”的低级回归。

### 5.3 aapt2（ARM64）
当前工程通过 `android.aapt2FromMavenOverride=.../aapt2` 绕过 ARM64 环境的 aapt2 获取问题。

**约定：**
- 工程在新机器上跑不起来时，优先检查 `gradle.properties` 中 aapt2 override。

---

## 6. 音频与资源命名约定（强约束，可复用）

### 6.1 音频资源命名
资源位置：`app/src/main/res/raw/`

命名模式（示例）：
- Street dialogue：`d1_s_1.mp3`（Day1 street line 1）
- Vocabulary：`d1_v_3.mp3`
- Court lexicon：`d1_c_5.mp3`

对应关系：
- `LessonRepository` 中的 `id`（如 `"d1_s_1"`）必须能被：
  - `resources.getIdentifier(id, "raw", packageName)` 找到。

### 6.2 播放逻辑
- `playAudio(id: String)`：同一个 id 若正在播放，再点一次停止；否则停止旧音频，播放新音频。

**验收：**
- 点击任一 bubble / vocab / lexicon item 必须能触发音频（若对应 raw 存在）。

---

## 7. 真机安装与三屏截图（“别瞎截图”协议）

### 7.1 设备前置
```bash
adb devices -l
```
必须确认：
- 有且仅有目标设备 `device` 状态。

### 7.2 安装指定 APK
```bash
adb install -r -d path/to.apk
adb shell dumpsys package com.example.lamha | grep -E 'versionName=|versionCode=|lastUpdateTime='
```
**必须记录** `lastUpdateTime` 以证明你确实装了“刚刚 build 的版本”。

### 7.3 导航与截图（Home / Gali / Leela）
稳定流程（以“点击第一课”作为入口）：

```bash
# 打开 App
adb shell monkey -p com.example.lamha -c android.intent.category.LAUNCHER 1
sleep 2

# Home 截图
adb exec-out screencap -p > lamha_home.png

# 点击第一张卡片（经验坐标；必要时改为 UIAutomator 精确定位）
adb shell input tap 720 868
sleep 2

# Gali 截图
adb exec-out screencap -p > lamha_gali.png

# 切换到 Leela tab（经验坐标）
adb shell input tap 883 2587
sleep 2

# Leela 截图
adb exec-out screencap -p > lamha_leela.png
```

### 7.4 防截错页门禁（强制）
每次截图前后都 dump 一次：

```bash
adb shell uiautomator dump /sdcard/ui.xml
adb pull /sdcard/ui.xml .
# 必须出现对应标题
grep -n "Gali · गली\|Leela · लीला" ui.xml
```

**规则：**
- 若 grep 不到对应标题 → 该截图作废，不发送，不用于 release。

### 7.5 可读性门禁（强制）
- Leela 诗歌卡片与 analysis 段落**必须肉眼可读**。
- 一旦出现“白底黄字不可读” → 视为 P0 回归，必须先修再发图/发包。

---

## 8. GitHub Release 流程（可复用模板）

### 8.1 推送 master
```bash
git checkout master
git pull --ff-only
# 确认无误后
git push origin master
```

### 8.2 打 tag（指向验收 commit）
```bash
git tag -a vX.Y.Z <commit> -m "Lamha vX.Y.Z"
git push origin vX.Y.Z
```

### 8.3 创建 Release + 上传 APK（使用 gh）
```bash
gh release create vX.Y.Z path/to/app-release-unsigned.apk \
  --title "Lamha vX.Y.Z" \
  --notes "Release based on commit <hash>.\n\nAssets: unsigned APK"
```

### 8.4 签名策略（关键现实）
当前 release 产物为 `app-release-unsigned.apk`。

若要“正式可发布/可升级安装”的 release：
- 需要配置 keystore（不建议把明文密码写进 repo）
- 推荐：用环境变量/CI secret 注入 signingConfig（后续 roadmap 见 §10）

---

## 9. 质量与交付约定（Conventions / SLO）

### 9.1 “版本一致性”约定
任何对外发送的 artifact（截图、APK、Release）必须绑定：
- commit hash
- build 时间/lastUpdateTime

### 9.2 “三屏一致性”约定
每次验收必须包含：
- Home（Lesson list）
- Gali（对话页）
- Leela（诗歌+解析+lexicon 其中至少一屏内容可读）

### 9.3 “不可跳过的检查”清单
- [ ] `git rev-parse HEAD` 与目标 commit 一致
- [ ] `adb dumpsys ... lastUpdateTime` 是刚安装的
- [ ] `uiautomator dump` 能 grep 到正确标题
- [ ] Leela 可读性通过

---

## 10. Future Items（按“最大复用”优先级）

> 原则：优先做“能把流程稳定化/可复现化”的改造，再做功能堆叠。

### P0：交付稳定性 / 可复现
1. **签名 Release（keystore + CI secrets）**
   - 输出：signed `app-release.apk`
   - 验收：可在同一设备上无卸载覆盖安装；版本可升级。
2. **截图自动化门禁**
   - 用 UIAutomator 精确定位元素（避免硬编码坐标）
   - 可读性阈值（对比度/像素统计）自动 fail。

### P1：内容与数据可扩展
3. **内容从硬编码迁移到 JSON（版本化 content pack）**
   - 目标：Lesson 数据可独立更新，不必改 APK。
   - 验收：加载本地 assets JSON；schema 校验；fallback。
4. **音频生成与一致性工具链**
   - 目标：给定 lessons JSON 自动生成/校验 raw 音频。

### P2：学习体验
5. **Progress / 完成度**
6. **Quiz mode**（Gali vocab / Leela lexicon 双轨测验）
7. **更强的音频体验**（队列、倍速、逐句播放、缓存策略）

---

## 11. 附录：定位常见问题（Troubleshooting）

### A) “我装了 APK 但 UI 还是旧的”
- 看 `adb dumpsys package ... lastUpdateTime`
- 确认安装命令成功，并非装到另一台设备/模拟器。

### B) “Leela 不可读（白底黄字）”
- 视为 P0 回归：先修对比（text color / container alpha / scrim）再截图。

### C) ARM64 构建问题
- 优先检查 `gradle.properties` 的 aapt2 override。
- 其次检查 Compose compiler extension 版本与 Kotlin 版本兼容性。

---

## 12. 当前关键文件索引（快速入口）
- `Claude.md`：产品愿景与模型概览
- `app/src/main/java/com/example/lamha/MainActivity.kt`：导航 + UI 主实现
- `app/src/main/java/com/example/lamha/LessonRepository.kt`：静态内容
- `app/src/main/java/com/example/lamha/ui/theme/*`：Material theme + Typography
- `app/src/main/res/drawable/bg_sandstone.jpg` / `bg_leela_combined.jpg`
- `app/src/main/res/raw/*`：音频 assets
