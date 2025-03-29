package com.mathislaurent.features.contest

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.mathislaurent.features.contest.navigation.ContestNavigationGraph

@Composable
fun ContestScreen(
    onClose: () -> Unit
) {
    ContestNavigationGraph(
        navController = rememberNavController(),
        onClose = onClose
    )
}