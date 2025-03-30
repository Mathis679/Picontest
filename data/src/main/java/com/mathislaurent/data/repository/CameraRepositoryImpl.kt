package com.mathislaurent.data.repository

import android.graphics.Bitmap
import com.mathislaurent.data.datasource.local.LocalPhotoDataSource
import com.mathislaurent.domain.repository.CameraRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.io.File

class CameraRepositoryImpl(
    private val localPhotoDataSource: LocalPhotoDataSource,
    private val dispatcher: CoroutineDispatcher
): CameraRepository {
    override suspend fun saveBitmap(bitmap: Bitmap) {
        withContext(dispatcher) {
            localPhotoDataSource.saveBitmap(bitmap)
        }
    }

    override fun getAppSavedImages(): Flow<List<File>> {
        return localPhotoDataSource
            .getAppSavedImages()
            .flowOn(dispatcher)
    }
}