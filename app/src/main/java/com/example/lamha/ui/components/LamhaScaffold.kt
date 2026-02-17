package com.example.lamha.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LamhaScaffold(
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    containerColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.background,
    content: @Composable (PaddingValues) -> Unit,
) {
    val insets = WindowInsets.safeDrawing

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = containerColor,
    ) {
        Scaffold(
            containerColor = containerColor,
            contentWindowInsets = insets,
            topBar = topBar,
            bottomBar = bottomBar,
        ) { inner ->
            content(inner)
        }
    }
}
