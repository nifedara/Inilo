package com.example.inilo.ui.component

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
import kotlinx.coroutines.delay

@Composable
fun IniloSplashAnimation(onAnimationEnd: () -> Unit) {
    val letters = listOf("I", "N", "I", "L", "O")
    val colors = listOf(
        Color(0xFF1565C0),
        Color(0xFFF57C00),
        Color(0xFF43A047),
        Color(0xFFD32F2F),
        Color(0xFFDF03FC)
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
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = colors[index]
                )
            }
            Spacer(Modifier.width(8.dp))
        }
    }
}

