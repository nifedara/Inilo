package com.example.inilo.ui.component.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.inilo.R
import com.example.inilo.ui.component.Solutions

val iniloFontFamily = FontFamily(
    Font(R.font.libertinusserif_regular, FontWeight.Normal),
    Font(R.font.libertinusserif_semibold, FontWeight.SemiBold),
    Font(R.font.libertinus_serif_bold, FontWeight.Bold),
    Font(R.font.libertinusserif_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.libertinus_serif_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.libertinus_serif_bold_italic, FontWeight.Bold, FontStyle.Italic),
)

val groupedSolutions = listOf (
    Solutions.Education,
    Solutions.Water,
    Solutions.Power,
    Solutions.HealthAndSanitation,
    Solutions.Food,
    Solutions.SafetyAndSecurity
)

val cardColors = listOf(
    Color(0xFFCAD3B1),
    Color(0xFFDBE6E3),
    Color(0xFFFFE4D6),
    Color(0xFFD7D9CE),
    Color(0xFFA2C5AC),
    Color(0xFFBD90DF),
)

val cardIcons = listOf(
    R.drawable.education,
    R.drawable.water,
    R.drawable.power,
    R.drawable.health,
    R.drawable.safety,
    R.drawable.education,
)