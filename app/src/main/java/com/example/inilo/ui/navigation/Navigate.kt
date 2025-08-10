package com.example.inilo.ui.navigation


sealed class Navigate(val route: String) {
    sealed class Screen {
        data object LandingScreen : Navigate("landing_screen")
    }
}