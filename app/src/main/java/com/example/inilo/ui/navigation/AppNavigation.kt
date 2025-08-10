package com.example.inilo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inilo.ui.screen.LandingScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigate.Screen.LandingScreen.route
    ) {
        composable(route = Navigate.Screen.LandingScreen.route) {
            LandingScreen()
        }
    }
}