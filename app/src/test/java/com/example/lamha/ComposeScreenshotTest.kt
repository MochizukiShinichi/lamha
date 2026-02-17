package com.example.lamha

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.ConscryptMode
import org.robolectric.annotation.GraphicsMode
import java.io.File
import java.io.FileOutputStream

@RunWith(RobolectricTestRunner::class)
@ConscryptMode(ConscryptMode.Mode.OFF)
@Config(sdk = [34])
@GraphicsMode(GraphicsMode.Mode.LEGACY)
@org.junit.Ignore("Device-driven screenshots now; JVM capture unstable on ARM64")
class ComposeScreenshotTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<androidx.activity.ComponentActivity>()

    private fun outputDir(): File = File("app/build/outputs/jvm-previews").apply { mkdirs() }

    @Test
    fun captureLeelaScreen() {
        // Enable auto-advance of animations
        composeRule.mainClock.autoAdvance = true
        
        val lesson = LessonRepository.getLessons().first()
        composeRule.setContent {
            MaterialTheme(colorScheme = CourtPalette) {
                Surface {
                    Box(modifier = Modifier.fillMaxSize().testTag("root")) {
                        CourtView(lesson.court, activeId = null, onPlay = {}, isDark = true)
                    }
                }
            }
        }
        
        // Wait for all animations and composition to complete
        composeRule.waitForIdle()
        // Advance time to ensure any delayed animations complete
        composeRule.mainClock.advanceTimeBy(1000L)
        
        val image = composeRule.onNodeWithTag("root").captureToImage()
        val bitmap = image.asAndroidBitmap()
        val file = File(outputDir(), "leela.png")
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }
    }

    @Test
    fun captureGaliScreen() {
        composeRule.mainClock.autoAdvance = true
        
        val lesson = LessonRepository.getLessons().first()
        composeRule.setContent {
            MaterialTheme(colorScheme = StreetPalette) {
                Surface {
                    Box(modifier = Modifier.fillMaxSize().testTag("root")) {
                        StreetView(lesson.street, activeId = null, onPlay = {})
                    }
                }
            }
        }
        
        composeRule.waitForIdle()
        composeRule.mainClock.advanceTimeBy(1000L)
        
        val image = composeRule.onNodeWithTag("root").captureToImage()
        val bitmap = image.asAndroidBitmap()
        val file = File(outputDir(), "gali.png")
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }
    }
}