package com.mathislaurent.domain.usecase.rate

import com.mathislaurent.domain.entity.RatePhoto
import com.mathislaurent.domain.repository.PhotoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn

class GetPhotoToRateUseCase(
    private val repository: PhotoRepository,
    private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<List<RatePhoto>> {
        return repository
            .getPhotoToRate()
            .distinctUntilChanged()
            .flowOn(dispatcher)
    }
}