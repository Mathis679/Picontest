package com.mathislaurent.domain.repository

import android.graphics.Bitmap
import kotlinx.coroutines.flow.Flow
import java.io.File

interface CameraRepository {
    suspend fun saveBitmap(bitmap: Bitmap)
    fun getAppSavedImages(): Flow<List<File>>
}