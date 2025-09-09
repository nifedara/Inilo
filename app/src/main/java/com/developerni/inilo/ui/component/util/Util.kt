package com.developerni.inilo.ui.component.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.developerni.inilo.R
import com.developerni.inilo.ui.component.Solutions

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
    //Color(0xFF3b1d38),
    Color(0xFF9168f5),
    Color(0xFF02bc59),
    Color(0xfffdce02),
    Color(0xFFff7865),
    Color(0xFF02bc59),
    Color(0xFF9168f5),
)
val cardIconColors = listOf(
    Color(0xFFfbf6ef),
    Color(0xFF000000),
    Color(0xFF000000),
    Color(0xFF000000),
    Color(0xFF000000),
    Color(0xFF000000),
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