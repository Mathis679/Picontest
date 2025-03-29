package com.mathislaurent.features.home.navigation

sealed class HomeNavigationItems(val screenRoute: String) {
    data object WelcomeNavItem: HomeNavigationItems("welcome")
    data object RankingNavItem: HomeNavigationItems("ranking")
}