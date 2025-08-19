package com.example.inilo.ui.component.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.inilo.R
import com.example.inilo.ui.component.Solutions

val iniloFontFamily = FontFamily(
    Font(R.font.lexend_thin, FontWeight.Thin),
    Font(R.font.lexend_extra_light, FontWeight.ExtraLight),
    Font(R.font.lexend_light, FontWeight.Light),
    Font(R.font.lexend_regular, FontWeight.Normal),
    Font(R.font.lexend_medium, FontWeight.Medium),
    Font(R.font.lexend_bold, FontWeight.Bold),
    Font(R.font.lexend_semi_bold, FontWeight.SemiBold),
    Font(R.font.lexend_extra_bold, FontWeight.ExtraBold),
    Font(R.font.lexend_black, FontWeight.Black),
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
    R.drawable.food,
    R.drawable.safety,
)

val cardIconSizes = listOf(
    26.dp,
    25.dp,
    29.dp,
    24.dp,
    24.dp,
    25.dp,
)