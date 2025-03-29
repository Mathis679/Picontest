package com.mathislaurent.domain.usecase.onboarding

import com.mathislaurent.domain.repository.OnBoardingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn

class ShouldShowOnBoardingUseCase(
    private val repository: OnBoardingRepository,
    private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<Boolean> {
        return repository
            .shouldShowOnBoarding()
            .distinctUntilChanged()
            .flowOn(dispatcher)
    }
}