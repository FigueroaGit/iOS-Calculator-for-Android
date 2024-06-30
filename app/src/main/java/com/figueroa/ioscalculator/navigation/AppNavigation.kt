package com.figueroa.ioscalculator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.figueroa.ioscalculator.screens.BasicCalculator

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.BasicCalculator.name) {
        composable(route = AppScreens.BasicCalculator.name) {
            BasicCalculator()
        }
    }
}