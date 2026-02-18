package com.example.lamha.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
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
    // Headings (Eczar) — keep close to baseline; too large hurts Leela aesthetics.
    displayLarge = baseline.displayLarge.copy(fontFamily = DisplayFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = DisplayFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = DisplayFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = DisplayFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = DisplayFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = DisplayFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = DisplayFontFamily, fontSize = 22.sp),
    titleMedium = baseline.titleMedium.copy(fontFamily = DisplayFontFamily, fontSize = 18.sp),
    titleSmall = baseline.titleSmall.copy(fontFamily = DisplayFontFamily, fontSize = 16.sp),

    // Body (Lato) — bump sizes for readability across the app.
    bodyLarge = baseline.bodyLarge.copy(fontFamily = BodyFontFamily, fontSize = 18.sp),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = BodyFontFamily, fontSize = 16.sp),
    bodySmall = baseline.bodySmall.copy(fontFamily = BodyFontFamily, fontSize = 14.sp),
    labelLarge = baseline.labelLarge.copy(fontFamily = BodyFontFamily, fontSize = 15.sp),
    labelMedium = baseline.labelMedium.copy(fontFamily = BodyFontFamily, fontSize = 13.sp),
    labelSmall = baseline.labelSmall.copy(fontFamily = BodyFontFamily, fontSize = 12.sp),
)
