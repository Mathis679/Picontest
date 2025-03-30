package com.mathislaurent.features.contest.rate

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun RateScreen(
    viewModel: RateViewModel = koinViewModel(),
    onClose: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    RateContent(
        uiState = uiState,
        onClose = onClose,
        onRatingChanged = { rate, photo ->
            viewModel.onRateChanged(rate, photo)
        }
    )
}