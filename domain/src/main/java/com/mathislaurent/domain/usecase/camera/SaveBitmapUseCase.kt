package com.mathislaurent.domain.usecase.camera

import android.graphics.Bitmap
import com.mathislaurent.domain.repository.CameraRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SaveBitmapUseCase(
    private val repository: CameraRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(bitmap: Bitmap) = withContext(dispatcher) {
        repository.saveBitmap(bitmap)
    }
}