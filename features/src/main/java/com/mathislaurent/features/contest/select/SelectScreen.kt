package com.mathislaurent.features.contest.select

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun SelectScreen(
    viewModel: SelectViewModel = koinViewModel(),
    onClose: () -> Unit,
    navigateToRate: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    SelectContent(
        uiState = uiState,
        onClose = {
            onClose()
        },
        onValidate = { file ->
            viewModel.onValidate(file)
            navigateToRate()
        }
    )
}