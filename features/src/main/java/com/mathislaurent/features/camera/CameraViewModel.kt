package com.mathislaurent.features.camera

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathislaurent.domain.usecase.camera.SaveBitmapUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CameraViewModel(
    private val saveBitmapUseCase: SaveBitmapUseCase
): ViewModel() {

    private val _finishCamera = MutableStateFlow<Boolean>(false)
    val finishCamera: StateFlow<Boolean> = _finishCamera

    fun onSavePhoto(bitmap: Bitmap) {
        val handler = CoroutineExceptionHandler { _, exception ->
            Log.e("Camera","Something went wrong during saving bitmap :")
            exception.printStackTrace()
        }
        viewModelScope.launch(handler) {
            saveBitmapUseCase(bitmap)
            //TODO display loading
            _finishCamera.update {
                true
            }
        }
    }
}