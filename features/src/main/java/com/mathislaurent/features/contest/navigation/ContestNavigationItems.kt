package com.mathislaurent.features.contest.navigation

sealed class ContestNavigationItems(val screenRoute: String) {
    data object SelectNavItem: ContestNavigationItems("select")
    data object RateNavItem: ContestNavigationItems("rate")
}