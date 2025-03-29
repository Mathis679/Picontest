package com.mathislaurent.domain.usecase.contest

import com.mathislaurent.domain.repository.CameraRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import java.io.File

class GetAppImagesUseCase(
    private val repository: CameraRepository,
    private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<List<File>> {
        return repository
            .getAppSavedImages()
            .distinctUntilChanged()
            .flowOn(dispatcher)
    }
}