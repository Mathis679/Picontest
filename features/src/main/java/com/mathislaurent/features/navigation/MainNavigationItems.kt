package com.mathislaurent.features.navigation

sealed class MainNavigationItems(val screenRoute: String) {
    data object LauncherNavItem: MainNavigationItems("launcher")
    data object OnBoardingNavItem: MainNavigationItems("onboarding")
    data object HomeNavItem: MainNavigationItems("home")
    data object ContestNavItem: MainNavigationItems("contest")
}