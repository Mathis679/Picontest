package com.mathislaurent.features.home.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mathislaurent.designsystem.ui.components.PTButton
import com.mathislaurent.features.R

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    openContest: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(R.string.home_title),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(
            modifier = Modifier.weight(1F)
        )

        PTButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.home_demo),
            onClick = {
                openContest()
            }
        )

        Spacer(
            modifier = Modifier.weight(1F)
        )
    }
}