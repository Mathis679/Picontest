package com.mathislaurent.data.repository

import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import com.mathislaurent.domain.repository.CameraRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

class CameraRepositoryImpl(
    private val context: Context,
    private val dispatcher: CoroutineDispatcher
): CameraRepository {
    override suspend fun saveBitmap(bitmap: Bitmap) {
        withContext(dispatcher) {
            val album = File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), PICONTEST_ALBUM)
            if (!album.exists()) {
                album.mkdirs()
            }
            val millis = System.currentTimeMillis()
            val imageFile = File(album, "$millis.png")
            FileOutputStream(imageFile).use {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
            }
        }
    }

    companion object {
        const val PICONTEST_ALBUM = "Picontest"
    }
}