package com.mathislaurent.domain.usecase.rank

import com.mathislaurent.domain.entity.RankPhoto
import com.mathislaurent.domain.repository.PhotoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn

class GetRankedPhotoListUseCase(
    private val repository: PhotoRepository,
    private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<List<RankPhoto>> {
        return repository
            .getRankedPhotos()
            .distinctUntilChanged()
            .flowOn(dispatcher)
    }
}