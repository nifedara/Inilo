package com.developerni.inilo.ui.component.util

import com.developerni.inilo.ui.component.SolutionScreenType
import com.developerni.inilo.ui.component.Solutions

fun Solutions.toScreenType(): SolutionScreenType = when (this) {
    Solutions.Education -> SolutionScreenType.Education
    Solutions.Water -> SolutionScreenType.Water
    Solutions.Power -> SolutionScreenType.Power
    Solutions.HealthAndSanitation -> SolutionScreenType.HealthAndSanitation
    Solutions.Food -> SolutionScreenType.Food
    Solutions.SafetyAndSecurity -> SolutionScreenType.SafetyAndSecurity
}