package com.mathislaurent.features.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mathislaurent.designsystem.ui.theme.PicontestTheme
import com.mathislaurent.features.R

@Composable
fun OnBoardingStep(
    step: OnBoardingViewModel.OnBoardingStep
) {
    val lottieComposition = rememberLottieComposition(LottieCompositionSpec.RawRes(step.lottieAnim))
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(step.titleStrId),
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            text = stringResource(step.contentStrId),
            style = MaterialTheme.typography.bodyLarge
        )
        LottieAnimation(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(250.dp, 250.dp),
            composition = lottieComposition.value,
            iterations = LottieConstants.IterateForever
        )
    }
}

@Preview
@Composable
private fun Preview() {
    PicontestTheme {
        OnBoardingStep(
            step = OnBoardingViewModel.OnBoardingStep(
                titleStrId = R.string.onboarding_step1_title,
                contentStrId = R.string.onboarding_step1_content,
                lottieAnim = R.raw.cup_anim
            )
        )
    }
}