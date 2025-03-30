package com.mathislaurent.data.datasource.local

import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileFilter
import java.io.FileOutputStream

class LocalPhotoDataSource(
    private val context: Context,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun saveBitmap(bitmap: Bitmap) {
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

    fun getAppSavedImages(): Flow<List<File>> = flow {
        val album = File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), PICONTEST_ALBUM)
        if (!album.exists() || !album.isDirectory) {
            emit(emptyList<File>())
        } else {
            album.listFiles(FileFilter { fileCreatedLastWeek(file = it) })?.asList()?.let {
                emit(it)
            } ?: run {
                emit(emptyList<File>())
            }
        }
    }.flowOn(dispatcher)

    private fun fileCreatedLastWeek(file: File): Boolean {
        val lastModifiedMillis = file.lastModified()
        val now = System.currentTimeMillis()
        return now - lastModifiedMillis <= WEEK_MS
    }

    companion object {
        const val PICONTEST_ALBUM = "Picontest"
        const val WEEK_MS = 7*24*60*60*1000
    }
}