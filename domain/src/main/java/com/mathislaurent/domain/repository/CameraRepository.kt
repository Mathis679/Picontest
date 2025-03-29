package com.mathislaurent.domain.repository

import android.graphics.Bitmap

interface CameraRepository {
    suspend fun saveBitmap(bitmap: Bitmap)
}