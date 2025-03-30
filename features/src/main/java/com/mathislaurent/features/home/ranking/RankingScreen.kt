package com.mathislaurent.features.home.ranking

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun RankingScreen(
    viewModel: RankingViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    RankingContent(
        modifier = modifier,
        uiState = uiState
    )
}