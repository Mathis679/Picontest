package com.mathislaurent.features.camera

import android.Manifest
import androidx.activity.ComponentActivity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.view.LifecycleCameraController
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.mathislaurent.designsystem.ui.theme.PicontestTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinContext

class CameraActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!hasRequiredPermissions()) {
            ActivityCompat.requestPermissions(this, CAMERAX_PERMISSIONS, 0)
        }
        setContent {
            KoinContext {
                val viewModel: CameraViewModel = koinViewModel()
                val bitmapToShow = remember {
                    mutableStateOf<Bitmap?>(null)
                }

                PicontestTheme {
                    LaunchedEffect(Unit) {
                        viewModel.finishCamera.collect {
                            if (it) {
                                finish()
                            }
                        }
                    }
                    CameraScreen(
                        bitmapToShow = bitmapToShow.value,
                        takePhoto = { controller ->
                            takePhoto(
                                controller = controller,
                                onPhotoTaken = { bitmap ->
                                    bitmapToShow.value = bitmap
                                }
                            )
                        },
                        onDeclinePhoto = {
                            bitmapToShow.value = null
                        },
                        onAcceptPhoto = { bitmap ->
                            viewModel.onSavePhoto(bitmap)
                        }
                    )
                }
            }
        }
    }

    private fun takePhoto(
        controller: LifecycleCameraController,
        onPhotoTaken: (Bitmap) -> Unit
    ) {
        controller.takePicture(
            ContextCompat.getMainExecutor(applicationContext),
            object : ImageCapture.OnImageCapturedCallback() {
                override fun onCaptureSuccess(image: ImageProxy) {
                    super.onCaptureSuccess(image)

                    val matrix = Matrix().apply {
                        postRotate(image.imageInfo.rotationDegrees.toFloat())
                    }
                    val rotatedBitmap = Bitmap.createBitmap(
                        image.toBitmap(),
                        0,
                        0,
                        image.width,
                        image.height,
                        matrix,
                        true
                    )

                    onPhotoTaken(rotatedBitmap)
                }

                override fun onError(exception: ImageCaptureException) {
                    super.onError(exception)
                    Log.e("Camera", "Couldn't take photo: ", exception)
                }
            }
        )
    }

    private fun hasRequiredPermissions(): Boolean {
        return CAMERAX_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(
                applicationContext,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }


    companion object {
        private val CAMERAX_PERMISSIONS = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        )

        fun newIntent(context: Context): Intent {
            return Intent(context, CameraActivity::class.java)
        }
    }

}