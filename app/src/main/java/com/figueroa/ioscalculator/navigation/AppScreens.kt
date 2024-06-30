package com.figueroa.ioscalculator.navigation

enum class AppScreens {
    BasicCalculator,
    ;
    companion object {
        fun fromRoute(route: String?): AppScreens = when (route?.substringBefore("/")) {
            BasicCalculator.name -> BasicCalculator
            null -> BasicCalculator
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}