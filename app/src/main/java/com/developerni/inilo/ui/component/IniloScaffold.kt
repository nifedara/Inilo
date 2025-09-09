package com.developerni.inilo.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.developerni.inilo.R
import com.developerni.inilo.ui.component.util.IniloScaffoldState
import com.developerni.inilo.ui.component.util.iniloFontFamily
import com.developerni.inilo.ui.component.util.rememberIniloScaffoldState
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IniloScaffold(
    onBack: (() -> Unit)? = null,
    pageTitle: String? = null,
    appBar: (@Composable () -> Unit)? = null,
    bottomBar: (@Composable () -> Unit)? = null,
    ignorePadding: Boolean = false,
    background: Color = Color(0xFFfbf6ef),
    appBarColor: Color? = null,
    backButtonColor: Color = Color.White,
    backButtonIconColor: Color? = null,
    scaffoldState: IniloScaffoldState = rememberIniloScaffoldState(),
    content: (@Composable (PaddingValues) -> Unit),
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.loading_animation_blue)
    )

    // animation progress
    val progress by animateLottieCompositionAsState(
        composition = composition, iterations = LottieConstants.IterateForever // Infinite looping
    )

    val blur: Dp by animateDpAsState(
        targetValue = if (scaffoldState.overlayVisible /*|| obscure*/) 8.dp else 0.dp,
        animationSpec = tween(
            durationMillis = 200,
        ),
        label = ""
    )

    val overlayAlpha: Float by animateFloatAsState(
        targetValue = if (scaffoldState.overlayVisible) 1f else 0f,
        animationSpec = tween(
            durationMillis = 800,
        ),
        label = ""
    )

    var delayDismiss by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    LaunchedEffect(scaffoldState.overlayVisible) {
        if (scaffoldState.overlayVisible) {
            keyboardController?.hide()
        }
    }

    LaunchedEffect(scaffoldState.displayMessage, delayDismiss) {
        if (scaffoldState.displayMessage) {
            delay(3000)
            if (!delayDismiss && scaffoldState.displayMessage) {
                scaffoldState.clearMessage()
            }
        }
    }

    Box {
        Box(
            modifier = Modifier
                .blur(blur)
                .fillMaxSize()
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
                                    fontSize = 22.sp,
                                    color = Color(0xFF3b1d38),
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        },
                        appBarColor = appBarColor,
                        backButtonColor = backButtonColor,
                        backButtonIconColor = backButtonIconColor,
                        modifier = Modifier.background(appBarColor ?: Color.Unspecified)
                    )
                },
                containerColor = background,
                bottomBar = {
                    if (bottomBar != null) {
                        bottomBar()
                        return@Scaffold
                    }
                }
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

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    if (scaffoldState.displayMessage) {
                        scaffoldState.clearMessage()
                    }
                },
            exit = fadeOut(),
            enter = fadeIn(),
            visible = (scaffoldState.overlayVisible || scaffoldState.displayMessage)/* && !ignoreMessages*/,
        ) {
            Column(
                modifier = Modifier
                    .alpha(alpha = overlayAlpha)
                    .fillMaxSize()
                    .background(Color.Black.copy(0.6f)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (scaffoldState.overlayVisible) {
                    Card(
                        modifier = Modifier,
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.elevatedCardElevation(2.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Spacer(modifier = Modifier.height(4.dp))

                            LottieAnimation(
                                composition = composition,
                                progress = progress,
                                modifier = Modifier
                                    .size(70.dp)
                                    .scale(2f)
                            )

                            Text(
                                scaffoldState.loadingText, style = TextStyle(
                                    fontFamily = iniloFontFamily,
                                    color = Color.Black,
                                    fontSize = 12.sp
                                ), modifier = Modifier.padding(horizontal = 20.dp)
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                }
            }
        }

        if(
            scaffoldState.uLoading
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(top = 30.dp)
                    .align(Alignment.TopCenter)
                    .background(Color.White)
            ) {
                // Text showing media is uploading
                Text(
                    text = "Loading...",
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Linear progress indicator
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}