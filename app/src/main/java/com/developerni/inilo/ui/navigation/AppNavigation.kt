package com.developerni.inilo.ui.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developerni.inilo.ui.component.SolutionScreenType
import com.developerni.inilo.ui.screen.EducationScreen
import com.developerni.inilo.ui.screen.EducationScreenNavigation
import com.developerni.inilo.ui.screen.FoodScreen
import com.developerni.inilo.ui.screen.FoodScreenNavigation
import com.developerni.inilo.ui.screen.HealthAndSanitationScreen
import com.developerni.inilo.ui.screen.HealthAndSanitationScreenNavigation
import com.developerni.inilo.ui.screen.LandingScreen
import com.developerni.inilo.ui.screen.LoginRequiredScreen
import com.developerni.inilo.ui.screen.LoginRequiredScreenNavigation
import com.developerni.inilo.ui.screen.PowerScreen
import com.developerni.inilo.ui.screen.PowerScreenNavigation
import com.developerni.inilo.ui.screen.ProfileScreen
import com.developerni.inilo.ui.screen.ProfileScreenNavigation
import com.developerni.inilo.ui.screen.SafetyAndSecurityScreen
import com.developerni.inilo.ui.screen.SafetyAndSecurityScreenNavigation
import com.developerni.inilo.ui.screen.SignInScreen
import com.developerni.inilo.ui.screen.SignInScreenNavigation
import com.developerni.inilo.ui.screen.SignUpScreen
import com.developerni.inilo.ui.screen.SignUpScreenNavigation
import com.developerni.inilo.ui.screen.WaterScreen
import com.developerni.inilo.ui.screen.WaterScreenNavigation
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
                    onProfileClick = {
                        navController.navigate(Navigate.Screen.ProfileScreen.route)
                    },
                    loginStateViewModel = viewModel,
                )
            }

            composable(route = Navigate.Screen.EducationScreen.route) {
                EducationScreen(
                    onRoute = {
                        when (it) {
                            EducationScreenNavigation.Back -> { navController.popBackStack() }
                            EducationScreenNavigation.LoginRequired -> { navController.navigate(Navigate.Screen.LoginRequiredScreen.route) }
                        }
                    },
                    loginStateViewModel = viewModel,
                )
            }

            composable(route = Navigate.Screen.WaterScreen.route) {
                WaterScreen(
                    onRoute = {
                        when (it) {
                            WaterScreenNavigation.Back -> { navController.popBackStack() }
                            WaterScreenNavigation.LoginRequired -> { navController.navigate(Navigate.Screen.LoginRequiredScreen.route) }
                        }
                    },
                    loginStateViewModel = viewModel,
                )
            }

            composable(route = Navigate.Screen.PowerScreen.route) {
                PowerScreen(
                    onRoute = {
                        when (it) {
                            PowerScreenNavigation.Back -> { navController.popBackStack() }
                            PowerScreenNavigation.LoginRequired -> { navController.navigate(Navigate.Screen.LoginRequiredScreen.route) }
                        }
                    },
                    loginStateViewModel = viewModel,
                )
            }

            composable(route = Navigate.Screen.HealthAndSanitationScreen.route) {
                HealthAndSanitationScreen(
                    onRoute = {
                        when (it) {
                            HealthAndSanitationScreenNavigation.Back -> { navController.popBackStack() }
                            HealthAndSanitationScreenNavigation.LoginRequired -> { navController.navigate(Navigate.Screen.LoginRequiredScreen.route) }
                        }
                    },
                    loginStateViewModel = viewModel,
                )
            }

            composable(route = Navigate.Screen.FoodScreen.route) {
                FoodScreen(
                    onRoute = {
                        when (it) {
                            FoodScreenNavigation.Back -> { navController.popBackStack() }
                            FoodScreenNavigation.LoginRequired -> { navController.navigate(Navigate.Screen.LoginRequiredScreen.route) }
                        }
                    },
                    loginStateViewModel = viewModel,
                )
            }

            composable(route = Navigate.Screen.SafetyAndSecurityScreen.route) {
                SafetyAndSecurityScreen(
                    onRoute = {
                        when (it) {
                            SafetyAndSecurityScreenNavigation.Back -> { navController.popBackStack() }
                            SafetyAndSecurityScreenNavigation.LoginRequired -> { navController.navigate(Navigate.Screen.LoginRequiredScreen.route) }
                        }
                    },
                    loginStateViewModel = viewModel
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
                    },
                    loginStateViewModel = viewModel
                )
            }

            composable(route = Navigate.Screen.SignUpScreen.route) {
                SignUpScreen(
                    onRoute = {
                        when (it) {
                            SignUpScreenNavigation.Back -> { navController.popBackStack() }
                            SignUpScreenNavigation.SignUpComplete -> { navController.navigate(Navigate.Screen.LandingScreen.route) }
                        }
                    },
                    loginStateViewModel = viewModel,
                )
            }

            composable(route = Navigate.Screen.SignInScreen.route) {
                SignInScreen(
                    onRoute = {
                        when (it) {
                            SignInScreenNavigation.Back -> { navController.popBackStack() }
                            SignInScreenNavigation.SignInComplete -> { navController.navigate(Navigate.Screen.LandingScreen.route) }
                        }
                    },
                    loginStateViewModel = viewModel,
                )
            }

            composable(route = Navigate.Screen.ProfileScreen.route) {
                ProfileScreen(
                    onRoute = {
                        when (it) {
                            ProfileScreenNavigation.Back -> { navController.popBackStack() }
                            ProfileScreenNavigation.Logout -> {  }
                            ProfileScreenNavigation.EditQuickActionsTab -> {}
                        }
                    },
                    loginStateViewModel = viewModel,
                )
            }
        }
    }
}