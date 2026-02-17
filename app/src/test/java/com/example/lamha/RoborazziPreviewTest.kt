package com.example.lamha

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
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
class RoborazziPreviewTest {

    private fun outputDir(): File = File("build/outputs/jvm-previews").apply { mkdirs() }

    private fun renderToPng(activity: ComponentActivity, name: String, content: @androidx.compose.runtime.Composable () -> Unit) {
        val composeView = ComposeView(activity).apply {
            setContent { content() }
        }
        
        // Attach to activity's window
        activity.setContentView(composeView)

        val width = 1080
        val height = 1920
        val widthSpec = android.view.View.MeasureSpec.makeMeasureSpec(width, android.view.View.MeasureSpec.EXACTLY)
        val heightSpec = android.view.View.MeasureSpec.makeMeasureSpec(height, android.view.View.MeasureSpec.EXACTLY)
        composeView.measure(widthSpec, heightSpec)
        composeView.layout(0, 0, width, height)

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        composeView.draw(canvas)

        val file = File(outputDir(), name)
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }
    }

    @Test
    fun captureLeelaScreen() {
        val activity = Robolectric.buildActivity(ComponentActivity::class.java).setup().get()
        val lesson = LessonRepository.getLessons().first()
        renderToPng(activity, "leela.png") {
            MaterialTheme(colorScheme = CourtPalette) {
                Surface {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CourtView(lesson.court, activeId = null, onPlay = {}, isDark = true)
                    }
                }
            }
        }
    }

    @Test
    fun captureGaliScreen() {
        val activity = Robolectric.buildActivity(ComponentActivity::class.java).setup().get()
        val lesson = LessonRepository.getLessons().first()
        renderToPng(activity, "gali.png") {
            MaterialTheme(colorScheme = StreetPalette) {
                Surface {
                    Box(modifier = Modifier.fillMaxSize()) {
                        StreetView(lesson.street, activeId = null, onPlay = {})
                    }
                }
            }
        }
    }
}
