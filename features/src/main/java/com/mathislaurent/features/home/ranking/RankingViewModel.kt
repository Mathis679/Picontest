package com.mathislaurent.features.home.ranking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathislaurent.domain.entity.RankPhoto
import com.mathislaurent.domain.usecase.rank.GetRankedPhotoListUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class RankingViewModel(
    getRankedPhotoListUseCase: GetRankedPhotoListUseCase
): ViewModel() {
    sealed class RankingUiState {
        data object Loading: RankingUiState()
        data class Success(
            val list: List<RankPhoto>
        ): RankingUiState()
    }

    val uiState: StateFlow<RankingUiState> = getRankedPhotoListUseCase()
        .map { list ->
            RankingUiState.Success(
                list = list
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = RankingUiState.Loading
        )
}