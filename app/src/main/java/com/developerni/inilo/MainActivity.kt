package com.developerni.inilo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.developerni.inilo.ui.component.IniloSplashAnimation
import com.developerni.inilo.ui.screen.EntryScreen
import com.developerni.inilo.ui.theme.IniloTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        splashScreen.setKeepOnScreenCondition {
            return@setKeepOnScreenCondition false
        }

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var keepSplashScreen by remember { mutableStateOf(true) }
            IniloTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    if (keepSplashScreen) {
                        IniloSplashAnimation {
                            keepSplashScreen = false
                        }
                    } else {
                        EntryScreen()
                        //AppNavigation()
                    }
                }
            }
        }
    }
}