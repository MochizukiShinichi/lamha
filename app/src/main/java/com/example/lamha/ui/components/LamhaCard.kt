package com.example.lamha.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.lamha.ui.designsystem.LocalRadius
import com.example.lamha.ui.designsystem.LocalSpacing

/**
 * A single, app-wide card primitive.
 * Style C DNA: dark surfaces, subtle outline, restrained elevation.
 */
@Composable
fun LamhaCard(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    elevation: Dp = 2.dp,
    border: BorderStroke? = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f)),
    contentPadding: PaddingValues = PaddingValues(LocalSpacing.current.lg),
    content: @Composable ColumnScope.() -> Unit,
) {
    val radius = LocalRadius.current
    Surface(
        modifier = modifier
            .shadow(elevation, RoundedCornerShape(radius.md), clip = false),
        shape = RoundedCornerShape(radius.md),
        color = containerColor,
        contentColor = contentColor,
        border = border,
        shadowElevation = elevation,
    ) {
        Column(modifier = Modifier.padding(contentPadding), content = content)
    }
}
