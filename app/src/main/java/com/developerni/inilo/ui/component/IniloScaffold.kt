package com.developerni.inilo.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IniloScaffold(
    onBack: (() -> Unit)? = null,
    pageTitle: String? = null,
    appBar: (@Composable () -> Unit)? = null,
    ignorePadding: Boolean = false,
    background: Color = Color(0xFFfbf6ef),
    appBarColor: Color? = null,
    content: (@Composable (PaddingValues) -> Unit),
) {
    Scaffold(
        topBar = {
            if (appBar != null) {
                appBar()
                return@Scaffold
            }

            if (pageTitle == null && onBack == null) return@Scaffold
            TopBar(
                onBackPressed = { onBack?.invoke() },
                title = {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = pageTitle ?: "",
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.secondary,
                            fontWeight = FontWeight.Bold,
                        )
                    } },
                appBarColor = appBarColor,
                modifier = Modifier.background(appBarColor ?: Color.Unspecified)
            )
        },
        containerColor = background
    ) { insets ->
        if (ignorePadding) {
            content(insets)
        } else {
            Box(modifier = Modifier.padding(insets)) {
                content(insets)
            }
        }
    }
}