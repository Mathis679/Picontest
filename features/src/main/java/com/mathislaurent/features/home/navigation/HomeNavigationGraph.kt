package com.mathislaurent.features.home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mathislaurent.features.home.ranking.RankingScreen
import com.mathislaurent.features.home.welcome.WelcomeScreen

@Composable
fun HomeNavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    openContest: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = HomeNavigationItems.WelcomeNavItem.screenRoute
    ) {
        composable(HomeNavigationItems.WelcomeNavItem.screenRoute) {
            WelcomeScreen(
                modifier = modifier,
                openContest = openContest
            )
        }
        composable(HomeNavigationItems.RankingNavItem.screenRoute) {
            RankingScreen(
                modifier = modifier
            )
        }
    }
}