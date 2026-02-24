package com.example.lamha.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Figma theme typography: Noto Sans (use system SansSerif to avoid resource crash)

private val NotoSans = FontFamily.SansSerif

private val baseline = Typography()

val LamhaTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = NotoSans, fontSize = 48.sp, fontWeight = FontWeight.Normal, lineHeight = 56.sp),
    displayMedium = baseline.displayMedium.copy(fontFamily = NotoSans),
    displaySmall = baseline.displaySmall.copy(fontFamily = NotoSans),

    headlineLarge = baseline.headlineLarge.copy(fontFamily = NotoSans, fontSize = 28.sp, fontWeight = FontWeight.Medium),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = NotoSans, fontSize = 24.sp, fontWeight = FontWeight.Medium),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = NotoSans, fontSize = 20.sp, fontWeight = FontWeight.Medium),

    titleLarge = baseline.titleLarge.copy(fontFamily = NotoSans, fontSize = 24.sp, fontWeight = FontWeight.Medium),
    titleMedium = baseline.titleMedium.copy(fontFamily = NotoSans, fontSize = 18.sp, fontWeight = FontWeight.Normal),
    titleSmall = baseline.titleSmall.copy(fontFamily = NotoSans, fontSize = 16.sp, fontWeight = FontWeight.Normal),

    bodyLarge = baseline.bodyLarge.copy(fontFamily = NotoSans, fontSize = 18.sp, fontWeight = FontWeight.Normal, lineHeight = 28.sp),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = NotoSans, fontSize = 16.sp, fontWeight = FontWeight.Normal, lineHeight = 24.sp),
    bodySmall = baseline.bodySmall.copy(fontFamily = NotoSans, fontSize = 14.sp, fontWeight = FontWeight.Light, lineHeight = 20.sp),

    labelLarge = baseline.labelLarge.copy(fontFamily = NotoSans, fontSize = 16.sp, fontWeight = FontWeight.Medium),
    labelMedium = baseline.labelMedium.copy(fontFamily = NotoSans, fontSize = 14.sp, fontWeight = FontWeight.Light),
    labelSmall = baseline.labelSmall.copy(fontFamily = NotoSans, fontSize = 12.sp, fontWeight = FontWeight.Light),
)
