package com.mathislaurent.features.launcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathislaurent.domain.usecase.onboarding.ShouldShowOnBoardingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LauncherViewModel(
    private val shouldShowOnBoardingUseCase: ShouldShowOnBoardingUseCase
): ViewModel() {
    private val _navigateTo = MutableStateFlow<NavigateTo?>(null)
    val navigateTo: StateFlow<NavigateTo?> = _navigateTo

    enum class NavigateTo {
        ON_BOARDING,
        HOME
    }

    fun clickOnContinue() {
        viewModelScope.launch {
            shouldShowOnBoardingUseCase()
                .collect { result ->
                    _navigateTo.update {
                        if (result) {
                            NavigateTo.ON_BOARDING
                        } else {
                            NavigateTo.HOME
                        }
                    }
                }
        }
    }
}