# Lamha (लम्हा)

A Hindi learning app with a dual-track approach: **Survival** (The Street) meets **Wisdom** (The Court).

## The Palace of Life

Lamha rejects the sterile "tourist phrasebook" approach. Instead, it offers a holistic journey into the soul of Hindi:

- **Gali (The Street)** — Practical, everyday Hindi for auto rickshaws, ordering food, bargaining, pharmacy
- **Leela (The Court)** — Spiritual, poetic Hindi from Amir Khusrau, Kabir, Ghalib, Mirabai, Premchand, Tulsidas, The Gita

## Tech Stack

| Component | Technology |
|-----------|------------|
| Platform | Android (Native) |
| Language | Kotlin |
| UI | Jetpack Compose (Material3) |
| Audio | Native MediaPlayer + Google TTS fallback |
| Translation | ML Kit (Hindi → English, offline capable) |
| Fonts | Eczar (Devanagari), Lato (Body) |

## Project Structure

```
app/src/main/java/com/example/lamha/
├── MainActivity.kt          # Main UI (Home + Lesson Detail)
├── Lesson.kt                # Data models
├── LessonRepository.kt      # 7 days of content
└── ui/
    ├── theme/
    │   ├── Color.kt         # GaliLightScheme, LeelaDarkScheme
    │   ├── Theme.kt         # LamhaTheme
    │   └── Type.kt          # Typography
    ├── components/          # Reusable UI components
    └── designsystem/        # Spacing, radius tokens
```

## Build

```bash
./gradlew assembleDebug
```

Output: `app/build/outputs/apk/debug/app-debug.apk`

## UI Verification (ARM64/Headless)

Since we develop on Orange Pi 5 without full emulator:

```bash
# Run unit tests
./gradlew testDebugUnitTest

# Build APK
./gradlew assembleDebug
```

For visual verification, install on device and screenshot.

## Design System

### Gali (Street) — Light Theme
- Background: `#FBF8F1` (cream)
- Surface: `#FFFFFF` (white cards)
- Primary: `#6B5B3D` (brown)
- Text: `#3E3226` (dark brown)

### Leela (Court) — Dark Theme
- Background: `#2A2420` (dark warm)
- Surface: `#1A1613` (dark cards)
- Primary: `#D4AA5C` (gold)
- Text: `#E8DFC8` (cream)

## Content (7 Days)

1. Auto Rickshaw / Amir Khusrau
2. Directions / Kabir
3. Ordering Food / Ghalib
4. Bargaining / Mirabai
5. Family Intro / Premchand
6. Pharmacy / Tulsidas
7. Train Travel / The Gita

## Figma Reference

Design source: https://github.com/MochizukiShinichi/Lamhafigma

## Branches

- `main` — Stable releases
- `download` — Debug APKs for testing

## License

Private — All rights reserved.
