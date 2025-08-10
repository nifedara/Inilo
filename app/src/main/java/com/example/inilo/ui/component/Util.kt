package com.example.inilo.ui.component

fun Solutions.toScreenType(): SolutionScreenType = when (this) {
    Solutions.Education -> SolutionScreenType.Education
    Solutions.Water -> SolutionScreenType.Water
    Solutions.Power -> SolutionScreenType.Power
    Solutions.HealthAndSanitation -> SolutionScreenType.HealthAndSanitation
    Solutions.Food -> SolutionScreenType.Food
    Solutions.SafetyAndSecurity -> SolutionScreenType.SafetyAndSecurity
}