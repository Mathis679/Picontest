package com.mathislaurent.features.camera

import android.app.Activity
import android.content.Context
import android.content.Intent

class CameraActivity: Activity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CameraActivity::class.java)
        }
    }
}