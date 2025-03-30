package com.mathislaurent.features.contest.rate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathislaurent.domain.entity.RatePhoto
import com.mathislaurent.domain.usecase.rate.GetPhotoToRateUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class RateViewModel(
    getPhotoToRateUseCase: GetPhotoToRateUseCase
): ViewModel() {
    sealed class RateUiState {
        data object Loading: RateUiState()
        data class Success(
            val list: List<RatePhoto>
        ): RateUiState()
    }

    val uiState: StateFlow<RateUiState> = getPhotoToRateUseCase()
        .map { list ->
            RateUiState.Success(
                list = list
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = RateUiState.Loading
        )


    fun onRateChanged(rate: Int, photo: RatePhoto) {
        // save new rate for photo
    }
}