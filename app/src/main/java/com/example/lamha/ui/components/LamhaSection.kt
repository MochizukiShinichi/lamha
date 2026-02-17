package com.example.lamha.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.lamha.ui.designsystem.LocalSpacing

@Composable
fun LamhaSectionTitle(
    text: String,
    modifier: Modifier = Modifier,
) {
    val s = LocalSpacing.current
    Text(
        text = text.uppercase(),
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        letterSpacing = 1.5.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier.padding(vertical = s.md),
    )
}
