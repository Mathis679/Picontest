package com.mathislaurent.features.launcher

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mathislaurent.designsystem.ui.components.PTButton
import com.mathislaurent.designsystem.ui.theme.PicontestTheme
import com.mathislaurent.features.R

@Composable
fun LauncherContent(
    onContinue: () -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Box(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                PTButton(
                    text = stringResource(R.string.demo_access),
                    onClick = onContinue
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PicontestTheme {
        LauncherContent(
            onContinue = {}
        )
    }
}