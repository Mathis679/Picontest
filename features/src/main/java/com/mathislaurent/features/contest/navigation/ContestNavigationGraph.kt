package com.mathislaurent.features.contest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mathislaurent.features.contest.rate.RateScreen
import com.mathislaurent.features.contest.select.SelectScreen

@Composable
fun ContestNavigationGraph(
    navController: NavHostController,
    onClose: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = ContestNavigationItems.SelectNavItem.screenRoute
    ) {
        composable(ContestNavigationItems.SelectNavItem.screenRoute) {
            SelectScreen(
                onClose = onClose,
                navigateToRate = {
                    navController.navigate(ContestNavigationItems.RateNavItem.screenRoute)
                }
            )
        }

        composable(ContestNavigationItems.RateNavItem.screenRoute) {
            RateScreen(
                onClose = onClose
            )
        }
    }
}