package com.mathislaurent.features.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mathislaurent.features.home.HomeScreen
import com.mathislaurent.features.launcher.LauncherScreen
import com.mathislaurent.features.onboarding.OnBoardingScreen

@Composable
fun MainNavigationGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MainNavigationItems.LauncherNavItem.screenRoute
    ) {
        composable(MainNavigationItems.LauncherNavItem.screenRoute) {
            LauncherScreen(
                navigateToHome = {
                    navController.navigate(MainNavigationItems.HomeNavItem.screenRoute)
                },
                navigateToOnBoarding = {
                    navController.navigate(MainNavigationItems.OnBoardingNavItem.screenRoute)
                }
            )
        }
        composable(MainNavigationItems.HomeNavItem.screenRoute) {
            HomeScreen()
        }
        composable(MainNavigationItems.OnBoardingNavItem.screenRoute) {
            OnBoardingScreen(
                navigateToHome = {
                    navController.navigate(MainNavigationItems.HomeNavItem.screenRoute)
                }
            )
        }
    }
}