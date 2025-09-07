package com.developerni.inilo.ui.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developerni.inilo.ui.component.SolutionScreenType
import com.developerni.inilo.ui.screen.EducationScreen
import com.developerni.inilo.ui.screen.FoodScreen
import com.developerni.inilo.ui.screen.HealthAndSanitationScreen
import com.developerni.inilo.ui.screen.LandingScreen
import com.developerni.inilo.ui.screen.LoginRequiredScreen
import com.developerni.inilo.ui.screen.LoginRequiredScreenNavigation
import com.developerni.inilo.ui.screen.PowerScreen
import com.developerni.inilo.ui.screen.SafetyAndSecurityScreen
import com.developerni.inilo.ui.screen.SafetyAndSecurityScreenNavigation
import com.developerni.inilo.ui.screen.SignInScreen
import com.developerni.inilo.ui.screen.SignInScreenNavigation
import com.developerni.inilo.ui.screen.SignUpScreen
import com.developerni.inilo.ui.screen.SignUpScreenNavigation
import com.developerni.inilo.ui.screen.WaterScreen
import com.developerni.inilo.ui.viewModel.LoginStateViewModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavigation(
    viewModel: LoginStateViewModel
) {
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
                    },
                    loginStateViewModel = viewModel
                )
            }

            composable(route = Navigate.Screen.EducationScreen.route) {
                EducationScreen(
                    onBack = { navController.popBackStack() }
                )
            }

            composable(route = Navigate.Screen.WaterScreen.route) {
                WaterScreen(
                    onBack = { navController.popBackStack() }
                )
            }

            composable(route = Navigate.Screen.PowerScreen.route) {
                PowerScreen(
                    onBack = { navController.popBackStack() }
                )
            }

            composable(route = Navigate.Screen.HealthAndSanitationScreen.route) {
                HealthAndSanitationScreen(
                    onBack = { navController.popBackStack() }
                )
            }

            composable(route = Navigate.Screen.FoodScreen.route) {
                FoodScreen(
                    onBack = { navController.popBackStack() }
                )
            }

            composable(route = Navigate.Screen.SafetyAndSecurityScreen.route) {
                SafetyAndSecurityScreen(
                    loginStateViewModel = viewModel,
                    onRoute = {
                        when (it) {
                            SafetyAndSecurityScreenNavigation.Back -> {
                                navController.popBackStack()
                            }

                            SafetyAndSecurityScreenNavigation.LoginRequired -> {
                                navController.navigate(Navigate.Screen.LoginRequiredScreen.route)
                            }
                        }
                    }
                )
            }

            composable(route = Navigate.Screen.LoginRequiredScreen.route) {
                LoginRequiredScreen(
                    onRoute = {
                        when (it) {
                            LoginRequiredScreenNavigation.Back -> { navController.popBackStack() }
                            LoginRequiredScreenNavigation.SignIn -> { navController.navigate(Navigate.Screen.SignInScreen.route) }
                            LoginRequiredScreenNavigation.SignUp -> { navController.navigate(Navigate.Screen.SignUpScreen.route) }
                        }
                    }
                )
            }

            composable(route = Navigate.Screen.SignUpScreen.route) {
                SignUpScreen(
                    onRoute = {
                        when (it) {
                            SignUpScreenNavigation.Back -> { navController.popBackStack() }
                            SignUpScreenNavigation.SignUpComplete -> { navController.navigate(Navigate.Screen.LandingScreen.route) }
                        }
                    }
                )
            }

            composable(route = Navigate.Screen.SignInScreen.route) {
                SignInScreen(
                    onRoute = {
                        when (it) {
                            SignInScreenNavigation.Back -> { navController.popBackStack() }
                            SignInScreenNavigation.SignInComplete -> { navController.navigate(Navigate.Screen.LandingScreen.route) }
                        }
                    }
                )
            }
        }
    }
}