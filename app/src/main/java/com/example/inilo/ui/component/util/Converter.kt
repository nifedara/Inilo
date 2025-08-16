package com.example.inilo.ui.component.util

import com.example.inilo.ui.component.SolutionScreenType
import com.example.inilo.ui.component.Solutions

fun Solutions.toScreenType(): SolutionScreenType = when (this) {
    Solutions.Education -> SolutionScreenType.Education
    Solutions.Water -> SolutionScreenType.Water
    Solutions.Power -> SolutionScreenType.Power
    Solutions.HealthAndSanitation -> SolutionScreenType.HealthAndSanitation
    Solutions.Food -> SolutionScreenType.Food
    Solutions.SafetyAndSecurity -> SolutionScreenType.SafetyAndSecurity
}