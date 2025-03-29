package com.mathislaurent.features.contest.select

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun SelectScreen(
    viewModel: SelectViewModel = koinViewModel(),
    onClose: () -> Unit,
    navigateToRate: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    when(uiState) {
        SelectViewModel.ContestUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }

        }
        is SelectViewModel.ContestUiState.Images -> {
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
    }

}