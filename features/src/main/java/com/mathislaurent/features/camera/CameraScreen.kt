package com.mathislaurent.features.camera

import android.graphics.Bitmap
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.mathislaurent.features.camera.photopreview.PhotoPreviewScreen

@Composable
fun CameraScreen(
    showLoading: Boolean,
    bitmapToShow: Bitmap?,
    takePhoto: (LifecycleCameraController) -> Unit,
    onDeclinePhoto: () -> Unit,
    onAcceptPhoto: (Bitmap) -> Unit
) {
    val context = LocalContext.current
    val controller = remember {
        LifecycleCameraController(context.applicationContext).apply {
            setEnabledUseCases(
                CameraController.IMAGE_CAPTURE
            )
        }
    }

    if (bitmapToShow != null) {
        PhotoPreviewScreen(
            showLoading = showLoading,
            bitmap = bitmapToShow,
            onDecline = {
                onDeclinePhoto()
            },
            onAccept = {
                onAcceptPhoto(bitmapToShow)
            }
        )
    } else {
        CameraContent(
            controller = controller,
            takePhoto = {
                takePhoto(controller)
            }
        )
    }
}