package com.mathislaurent.features.home.welcome

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    openContest: () -> Unit
) {
    WelcomeContent(
        modifier = modifier,
        openContest = openContest
    )
}