package com.developerni.inilo.ui.navigation


sealed class Navigate(val route: String) {
    sealed class Screen {
        data object LandingScreen : Navigate("landing_screen")
        data object EducationScreen : Navigate("education_screen")
        data object WaterScreen : Navigate("water_screen")
        data object PowerScreen : Navigate("power_screen")
        data object HealthAndSanitationScreen : Navigate("health_screen")
        data object FoodScreen : Navigate("food_screen")
        data object SafetyAndSecurityScreen : Navigate("safety_screen")
        data object LoginRequiredScreen : Navigate("login_required_screen")
        data object SignUpScreen : Navigate("signUp_screen")
        data object SignInScreen : Navigate("signIn_screen")
        data object ProfileScreen : Navigate("profile_screen")
    }
}