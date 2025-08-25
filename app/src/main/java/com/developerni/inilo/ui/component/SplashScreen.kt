package com.developerni.inilo.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerni.inilo.ui.component.util.iniloFontFamily
import kotlinx.coroutines.delay

@Composable
fun IniloSplashAnimation(onAnimationEnd: () -> Unit) {
    val letters = listOf("I", "N", "I", "L", "O")
    val colors = listOf(
        Color(0xFFAFBC88),
        Color(0xFF40531B),
        Color(0xFF7AA095),
        Color(0xFFFFC09F),
        Color(0xFF618B4A),
    )

    var visibleCount by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        letters.forEachIndexed { index, _ ->
            delay(300)
            visibleCount = index + 1
        }
        delay(500)
        onAnimationEnd()
    }

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        letters.forEachIndexed { index, letter ->
            AnimatedVisibility(
                visible = index < visibleCount,
                enter = fadeIn(animationSpec = tween(500)) + scaleIn(),
                exit = fadeOut()
            ) {
                Text(
                    text = letter,
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = iniloFontFamily,
                    color = colors[index]
                )
            }
            Spacer(Modifier.width(8.dp))
        }
    }
}

