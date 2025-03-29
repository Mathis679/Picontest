package com.mathislaurent.domain.usecase.onboarding

import com.mathislaurent.domain.repository.OnBoardingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SetShowOnBoardingUseCase(
    private val repository: OnBoardingRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke() {
        withContext(dispatcher) {
            repository.setShowOnBoarding(false)
        }
    }
}