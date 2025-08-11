package com.example.inilo.ui.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inilo.ui.component.SolutionScreenType
import com.example.inilo.ui.screen.EducationScreen
import com.example.inilo.ui.screen.LandingScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = Navigate.Screen.LandingScreen.route
        ) {
            composable(route = Navigate.Screen.LandingScreen.route) {
                LandingScreen(
                    onSolutionClick = { solutionTypes ->
                        when (solutionTypes) {
                            SolutionScreenType.Education -> {
                                navController.navigate(Navigate.Screen.EducationScreen.route)
                            }

                            SolutionScreenType.Water -> {
                                navController.navigate(Navigate.Screen.WaterScreen.route)
                            }

                            SolutionScreenType.Power -> {
                                navController.navigate(Navigate.Screen.PowerScreen.route)
                            }

                            SolutionScreenType.HealthAndSanitation -> {
                                navController.navigate(Navigate.Screen.HealthAndSanitationScreen.route)
                            }

                            SolutionScreenType.Food -> {
                                navController.navigate(Navigate.Screen.FoodScreen.route)
                            }

                            SolutionScreenType.SafetyAndSecurity -> {
                                navController.navigate(Navigate.Screen.SafetyAndSecurityScreen.route)
                            }
                        }
                    }
                )
            }

            composable(route = Navigate.Screen.EducationScreen.route) {
                EducationScreen(
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}