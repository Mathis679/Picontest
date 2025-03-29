package com.mathislaurent.features.contest.select

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathislaurent.domain.usecase.contest.GetAppImagesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.io.File

class SelectViewModel(
    getAppImagesUseCase: GetAppImagesUseCase
): ViewModel() {
    sealed class ContestUiState {
        data object Loading: ContestUiState()
        data class Images(
            val list: List<File>
        ): ContestUiState()
    }

    val uiState: StateFlow<ContestUiState> = getAppImagesUseCase()
        .map { list ->
            ContestUiState.Images(
                list = list
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ContestUiState.Loading
        )

    fun onValidate(fileName: File) {
        // call server
    }
}