package com.example.lamha.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.lamha.R

// Typography for style C:
// - Display/Headline/Title: Eczar (serif)
// - Body/Label: Lato (sans)

private val DisplayFontFamily = FontFamily(
    Font(R.font.eczar_variable, FontWeight.Normal),
    Font(R.font.eczar_variable, FontWeight.Bold),
)

private val BodyFontFamily = FontFamily(
    Font(R.font.lato_regular, FontWeight.Normal),
    Font(R.font.lato_bold, FontWeight.Bold),
)

private val baseline = Typography()

val LamhaTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = DisplayFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = DisplayFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = DisplayFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = DisplayFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = DisplayFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = DisplayFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = DisplayFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = DisplayFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = DisplayFontFamily),

    bodyLarge = baseline.bodyLarge.copy(fontFamily = BodyFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = BodyFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = BodyFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = BodyFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = BodyFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = BodyFontFamily),
)
