package com.developerni.inilo.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    onBackPressed: () -> Unit,
    backButtonColor: Color = Color.White,
    backButtonIconColor: Color? = Color.White,
    title: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit = {},
    appBarColor: Color? = null
) {

    val foregroundColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = appBarColor ?: MaterialTheme.colorScheme.inverseSurface,
        scrolledContainerColor = appBarColor ?: MaterialTheme.colorScheme.inverseSurface,
    )
    Box(
        modifier = Modifier.background(Color(0xFFF6F5F5)),
        contentAlignment = Alignment.TopStart
    ) {
        CenterAlignedTopAppBar(
            modifier = modifier,
            actions = actions,
            title = title,
            scrollBehavior = scrollBehavior,
            colors = foregroundColors,
            navigationIcon = {
                IconButton(
                    onClick = onBackPressed,
                    colors = IconButtonDefaults.iconButtonColors(containerColor = backButtonColor)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "",
                        tint = backButtonIconColor ?: MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        )
    }
}