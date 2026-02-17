package com.example.lamha

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.lamha.ui.theme.LamhaTheme
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lamha.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LamhaApp()
        }
    }
}

val EczarFont = FontFamily(
    Font(R.font.eczar_variable, FontWeight.Normal),
    Font(R.font.eczar_variable, FontWeight.Bold)
)

val LatoFont = FontFamily(
    Font(R.font.lato_regular, FontWeight.Normal),
    Font(R.font.lato_bold, FontWeight.Bold)
)

// --- DESIGN TOKENS ---
val GaliShape = RoundedCornerShape(14.dp) // Refined for Gali
val LeelaShape = RoundedCornerShape(24.dp) // Organic for Leela
val SharedPadding = 16.dp

// Colors
val GaliHeaderBg = Color(0xFFF4F1EA)
val GaliHeaderDivider = Color(0xFFE5DED2)
val GaliTitleColor = Color(0xFF3E5E4B)
val GaliSectionHeaderColor = Color(0xFF6F6A60)
val GaliPlayBtnBg = Color(0xFFEFEAE0)

// Theme Palette Definitions
val CourtPalette = darkColorScheme(
    primary = Color(0xFFFFD700),    // Gold
    secondary = Color(0xFFD4AF37),  // Metallic Gold
    tertiary = Color(0xFF8D6E63),   // Bronze
    background = Color.Transparent, // Let the image show
    surface = Color(0x24FFFFFF),    // Frosted glass
    surfaceVariant = Color(0x1AFFFFFF),
    onSurface = Color(0xFFFFECB3),  // Pale Gold Text
    onSurfaceVariant = Color(0xFFE6D7B8),
    onPrimary = Color.Black
)

@Composable
fun LamhaApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    LamhaTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Crossfade(targetState = currentScreen, animationSpec = tween(500)) { screen ->
                when (screen) {
                    is Screen.Home -> HomeScreen(
                        onLessonClick = { lesson -> currentScreen = Screen.LessonDetail(lesson) }
                    )
                    is Screen.LessonDetail -> LessonDetailScreen(
                        lesson = screen.lesson,
                        onBack = { currentScreen = Screen.Home }
                    )
                }
            }
        }
    }
}

sealed class Screen {
    object Home : Screen()
    data class LessonDetail(val lesson: Lesson) : Screen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onLessonClick: (Lesson) -> Unit) {
    val lessons = remember { LessonRepository.getLessons() }
    val s = com.example.lamha.ui.designsystem.LocalSpacing.current

    com.example.lamha.ui.components.LamhaScaffold(
        topBar = {
            com.example.lamha.ui.components.LamhaTopBar(
                title = {
                    Text(
                        text = "लम्हा",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Bold,
                    )
                },
                containerColor = Color.Transparent,
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = PaddingValues(
                start = s.lg,
                end = s.lg,
                top = s.sm,
                bottom = s.xxl,
            ),
            verticalArrangement = Arrangement.spacedBy(s.lg),
            modifier = Modifier.padding(padding)
        ) {
            item {
                Text(
                    text = "The Palace of Life",
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            items(lessons) { lesson ->
                com.example.lamha.ui.components.LamhaCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onLessonClick(lesson) },
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                    elevation = 3.dp,
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(52.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.surfaceVariant),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = lesson.dayTitle.takeLast(1),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Spacer(modifier = Modifier.width(s.lg))
                            Column {
                                Text(
                                    text = lesson.dayTitle,
                                    style = MaterialTheme.typography.headlineSmall,
                                )
                                Text(
                                    text = lesson.street.title,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onSurface,
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(s.sm))
                        com.example.lamha.ui.components.LamhaDivider()
                        Spacer(modifier = Modifier.height(s.sm))
                        Column {
                            Text(
                                text = lesson.court.title,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                            Spacer(modifier = Modifier.height(s.xs))
                            // Removed redundant Gali/Leela label for cleaner cards

                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonDetailScreen(lesson: Lesson, onBack: () -> Unit) {
    var selectedTab by remember { mutableStateOf(0) } // 0 = Street, 1 = Court
    
    // Audio Player
    val context = LocalContext.current
    var activeAudioId by remember { mutableStateOf<String?>(null) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.stop()
            mediaPlayer?.release()
        }
    }

    fun playAudio(id: String) {
        if (activeAudioId == id && mediaPlayer?.isPlaying == true) {
            mediaPlayer?.stop()
            activeAudioId = null
            return
        }
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        activeAudioId = null

        val resId = context.resources.getIdentifier(id, "raw", context.packageName)
        if (resId != 0) {
            mediaPlayer = MediaPlayer.create(context, resId).apply {
                setOnCompletionListener { activeAudioId = null }
                start()
            }
            activeAudioId = id
        }
    }

    LamhaTheme(darkTheme = false) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (selectedTab == 1) {
                // Leela (Court) - Dark parchment + mandala
                Image(
                    painter = androidx.compose.ui.res.painterResource(R.drawable.bg_leela_combined),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                // Light scrim to keep gold lines visible
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.35f))
                )
            } else {
                // Gali (Street) - Light parchment
                Image(
                    painter = androidx.compose.ui.res.painterResource(R.drawable.bg_sandstone),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                // Gentle scrim for readability (keep light feel)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background.copy(alpha = 0.25f))
                )
            }

            // Content Scaffold
            com.example.lamha.ui.components.LamhaScaffold(
                containerColor = if (selectedTab == 1) Color.Transparent else MaterialTheme.colorScheme.background,
                topBar = {
                    com.example.lamha.ui.components.LamhaTopBar(
                        title = {
                            val titleText = if (selectedTab == 1) "Leela · लीला" else "Gali · गली"
                            Text(
                                text = titleText,
                                style = MaterialTheme.typography.titleLarge,
                                color = if (selectedTab == 1) CourtPalette.onSurface else MaterialTheme.colorScheme.onSurface,
                                fontFamily = if (selectedTab == 1) EczarFont else LatoFont,
                                letterSpacing = if (selectedTab == 0) 1.0.sp else 0.sp,
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, "Back") }
                        },
                        containerColor = if (selectedTab == 1) Color.Transparent else MaterialTheme.colorScheme.surface,
                    )
                },
                bottomBar = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        com.example.lamha.ui.components.LamhaCard(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant,
                            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            elevation = 4.dp,
                            modifier = Modifier
                                .height(52.dp)
                                .clip(RoundedCornerShape(50)),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            ) {
                                TabButton(
                                    text = "Gali",
                                    subText = "गली",
                                    icon = Icons.Default.DirectionsCar,
                                    isSelected = selectedTab == 0,
                                    selectedColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                    unselectedColor = MaterialTheme.colorScheme.onSurfaceVariant
                                ) { selectedTab = 0 }

                                Spacer(modifier = Modifier.width(8.dp))

                                TabButton(
                                    text = "Leela",
                                    subText = "लीला",
                                    icon = Icons.Default.TempleHindu,
                                    isSelected = selectedTab == 1,
                                    selectedColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                    unselectedColor = MaterialTheme.colorScheme.onSurfaceVariant
                                ) { selectedTab = 1 }
                            }
                        }
                    }
                }
            ) { padding ->
                Crossfade(
                    targetState = selectedTab,
                    animationSpec = tween(350),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) { tab ->
                    if (tab == 0) {
                        StreetView(lesson.street, activeAudioId, ::playAudio)
                    } else {
                        MaterialTheme(colorScheme = CourtPalette) {
                            CourtView(lesson.court, activeAudioId, ::playAudio)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TabButton(text: String, subText: String, icon: androidx.compose.ui.graphics.vector.ImageVector, isSelected: Boolean, selectedColor: Color, unselectedColor: Color = Color.LightGray, onClick: () -> Unit) {
    val bgColor by animateColorAsState(if (isSelected) Color.White.copy(alpha=0.1f) else Color.Transparent)
    val contentColor by animateColorAsState(if (isSelected) selectedColor else unselectedColor)
    
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(bgColor)
            .clickable { onClick() }
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, null, tint = contentColor, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text, 
                color = contentColor, 
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal, 
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                subText, 
                color = contentColor.copy(alpha = 0.8f), 
                fontWeight = FontWeight.Normal, 
                style = MaterialTheme.typography.labelSmall,
                fontFamily = EczarFont
            )
        }
    }
}

// ---------------- STREET UI (Clean, Modern, Functional) ----------------

@Composable
fun StreetView(section: StreetSection, activeId: String?, onPlay: (String) -> Unit) {
    val s = com.example.lamha.ui.designsystem.LocalSpacing.current
    LazyColumn(
        contentPadding = PaddingValues(bottom = 100.dp, top = s.lg, start = s.lg, end = s.lg),
        verticalArrangement = Arrangement.spacedBy(s.md)
    ) {
        item {
            com.example.lamha.ui.components.LamhaSectionTitle("Gali · गली")
            Text(
                text = section.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = s.xs, bottom = s.md)
            )
        }

        items(section.dialogue) { line ->
            StreetBubble(line, activeId == line.id) { onPlay(line.id) }
        }

        item { com.example.lamha.ui.components.LamhaSectionTitle("Vocabulary") }

        items(section.vocabulary) { vocab ->
            VocabItemRow(vocab, activeId == vocab.id) { onPlay(vocab.id) }
        }

        item { com.example.lamha.ui.components.LamhaSectionTitle("Grammar Notes") }

        items(section.grammarGuides) { grammar ->
            GrammarCard(grammar)
        }
    }
}

@Composable
fun StreetBubble(line: DialogueLine, isPlaying: Boolean, onPlay: () -> Unit) {
    val s = com.example.lamha.ui.designsystem.LocalSpacing.current
    val r = com.example.lamha.ui.designsystem.LocalRadius.current

    // Left side = service/local speaker; Right side = learner
    val leftSpeakers = setOf("Auto Driver", "Local", "Server", "Shopkeeper", "Host", "Chemist", "Official")
    val isLeft = line.speaker in leftSpeakers
    val align = if (isLeft) Alignment.Start else Alignment.End

    // Style C: use surfaceVariant for incoming, primaryContainer for outgoing
    val containerColor = if (isLeft) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.primaryContainer
    val contentColor = if (isLeft) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onPrimaryContainer
    // Highlight playing state with a border or subtle elevation change
    val baseBorder = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.7f))
    val border = if (isPlaying) BorderStroke(2.dp, MaterialTheme.colorScheme.primary) else baseBorder
    val elevation = if (isPlaying) 6.dp else 3.dp

    Column(modifier = Modifier.fillMaxWidth().padding(vertical = s.xs), horizontalAlignment = align) {
        Text(
            text = line.speaker,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f),
            modifier = Modifier.padding(horizontal = s.sm, vertical = s.xs)
        )
        Surface(
            modifier = Modifier.widthIn(max = 340.dp).clickable { onPlay() },
            color = containerColor,
            contentColor = contentColor,
            shadowElevation = elevation,
            shape = if (isLeft) RoundedCornerShape(r.xs, r.lg, r.lg, r.lg) else RoundedCornerShape(r.lg, r.xs, r.lg, r.lg),
            border = border
        ) {
            Column(modifier = Modifier.padding(s.md)) {
                Text(line.hindi, style = MaterialTheme.typography.bodyLarge)
                Text(
                    line.english,
                    style = MaterialTheme.typography.bodyMedium,
                    color = contentColor.copy(alpha = 0.72f)
                )
            }
        }
    }
}

@Composable
fun VocabItemRow(vocab: VocabItem, isPlaying: Boolean, onPlay: () -> Unit) {
    val activeColor = MaterialTheme.colorScheme.primary
    val s = com.example.lamha.ui.designsystem.LocalSpacing.current

    com.example.lamha.ui.components.LamhaCard(
        modifier = Modifier.fillMaxWidth().clickable { onPlay() },
        containerColor = if (isPlaying) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surface,
        elevation = if (isPlaying) 4.dp else 1.dp,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                if (isPlaying) Icons.Default.VolumeUp else Icons.Default.PlayCircleOutline,
                contentDescription = "Play",
                tint = if (isPlaying) activeColor else MaterialTheme.colorScheme.outline,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(s.lg))
            Column {
                Text(vocab.word, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                Text(vocab.meaning, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

// ---------------- COURT UI (Elegant, Serif, Deep) ----------------

@Composable
fun CourtView(section: CourtSection, activeId: String?, onPlay: (String) -> Unit) {
    val s = com.example.lamha.ui.designsystem.LocalSpacing.current
    val r = com.example.lamha.ui.designsystem.LocalRadius.current

    LazyColumn(contentPadding = PaddingValues(bottom = 100.dp, top = s.lg, start = s.xl, end = s.xl)) {
        item {
            Text(
                section.title,
                style = MaterialTheme.typography.headlineLarge,
                fontFamily = EczarFont,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = s.xl).fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        item {
            com.example.lamha.ui.components.LamhaCard(
                containerColor = MaterialTheme.colorScheme.surface,
                elevation = 6.dp,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.6f))
            ) {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    section.poemLines.forEach { line ->
                        Text(
                            text = line,
                            style = MaterialTheme.typography.headlineSmall,
                            fontFamily = EczarFont,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(s.md))
                    }
                }
            }
        }

        item { com.example.lamha.ui.components.LamhaDivider() }

        item {
            com.example.lamha.ui.components.LamhaCard(
                elevation = 4.dp,
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            ) {
                Text(
                    section.analysis,
                    style = MaterialTheme.typography.bodyLarge,
                    fontFamily = LatoFont,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 28.sp
                )
            }
        }

        item { com.example.lamha.ui.components.LamhaDivider() }
        item { com.example.lamha.ui.components.LamhaSectionTitle("Lexicon") }

        items(section.wordBreakdown) { word ->
            CourtLexiconItem(word, activeId == word.id, { onPlay(word.id) })
        }
    }
}

@Composable
fun CourtLexiconItem(word: WordAnalysis, isPlaying: Boolean, onPlay: () -> Unit) {
    val activeColor = MaterialTheme.colorScheme.primary
    val s = com.example.lamha.ui.designsystem.LocalSpacing.current

    com.example.lamha.ui.components.LamhaCard(
        modifier = Modifier.fillMaxWidth().clickable { onPlay() },
        elevation = if (isPlaying) 8.dp else 3.dp,
        containerColor = if (isPlaying) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant,
        contentColor = if (isPlaying) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    word.word,
                    style = MaterialTheme.typography.titleLarge,
                    fontFamily = EczarFont
                )
                Spacer(modifier = Modifier.weight(1f))
                if (isPlaying) Icon(Icons.Default.VolumeUp, null, tint = activeColor, modifier = Modifier.size(16.dp))
            }
            Spacer(modifier = Modifier.height(s.xs))
            Row {
                Text("Lit: ", color = MaterialTheme.colorScheme.outline, style = MaterialTheme.typography.labelMedium)
                Text(word.literal, color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.bodyMedium)
            }
            Row {
                Text("Meta: ", color = activeColor.copy(alpha = 0.85f), style = MaterialTheme.typography.labelMedium)
                Text(word.metaphor, color = MaterialTheme.colorScheme.onSurface, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
    Spacer(modifier = Modifier.height(s.md))
}

// --- SHARED UTILS ---

@Composable
fun SectionTitle(text: String, color: Color = Color.Gray) {
    Text(
        text = text.uppercase(),
        style = MaterialTheme.typography.labelMedium,
        color = color,
        letterSpacing = 1.5.sp,
        modifier = Modifier.padding(vertical = 12.dp)
    )
}

@Composable
fun SectionDivider(color: Color = Color.LightGray.copy(alpha = 0.2f)) {
    Divider(color = color, modifier = Modifier.padding(vertical = 24.dp))
}

@Composable
fun LeelaDivider() {
    val gold = MaterialTheme.colorScheme.primary
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(modifier = Modifier.weight(1f), color = gold.copy(alpha = 0.5f)) // Brighter line
        Spacer(modifier = Modifier.width(10.dp))
        Surface(
            shape = CircleShape,
            color = Color.Black.copy(alpha = 0.3f), // Darker center
            border = BorderStroke(1.dp, gold)
        ) {
            Box(modifier = Modifier.size(8.dp))
        }
        Spacer(modifier = Modifier.width(10.dp))
        Divider(modifier = Modifier.weight(1f), color = gold.copy(alpha = 0.5f))
    }
}

@Composable
fun GrammarCard(grammar: GrammarPoint) {
    com.example.lamha.ui.components.LamhaCard(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        elevation = 1.dp
    ) {
        Column {
            Text(grammar.title, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(grammar.content, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

// --- PREVIEWS (FOR FAST ITERATION) ---
// Use the "Split" or "Design" view in Android Studio to see these update in real-time.

@Composable
fun ClayCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    elevation: androidx.compose.ui.unit.Dp = 4.dp,
    shape: androidx.compose.ui.graphics.Shape = RoundedCornerShape(24.dp),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(16.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier
            .padding(bottom = 6.dp)
            .shadow(elevation, shape, clip = false)
            .offset(y = if (elevation > 0.dp) 4.dp else 0.dp),
        shape = shape,
        color = backgroundColor,
        shadowElevation = elevation,
        border = border ?: if (elevation > 0.dp) null else BorderStroke(1.dp, Color(0x33000000))
    ) {
        Column(modifier = Modifier.padding(contentPadding), content = content)
    }
}

@Preview(showBackground = true, name = "Gali Mode (Street)", heightDp = 800)
@Composable
fun PreviewGali() {
    val dummyLesson = LessonRepository.getLessons().first()
    LamhaTheme {
        Surface {
           StreetView(dummyLesson.street, null) {}
        }
    }
}

@Preview(showBackground = true, name = "Leela Mode (Court)", heightDp = 800)
@Composable
fun PreviewLeela() {
    val dummyLesson = LessonRepository.getLessons().first()
    LamhaTheme {
        Surface(color = Color.Black) { // Preview with dark background
           CourtView(dummyLesson.court, null, {})
        }
    }
}
