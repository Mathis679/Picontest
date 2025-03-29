package com.mathislaurent.features.onboarding

import androidx.annotation.RawRes
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathislaurent.domain.usecase.onboarding.SetShowOnBoardingUseCase
import com.mathislaurent.features.R
import kotlinx.coroutines.launch

class OnBoardingViewModel(
    private val setShowOnBoardingUseCase: SetShowOnBoardingUseCase
): ViewModel() {
    data class OnBoardingStep(
        @StringRes
        val titleStrId: Int,
        @StringRes
        val contentStrId: Int,
        @RawRes
        val lottieAnim: Int
    )

    val onBoardingSteps = listOf(
        OnBoardingStep(
            titleStrId = R.string.onboarding_step1_title,
            contentStrId = R.string.onboarding_step1_content,
            lottieAnim = R.raw.cup_anim
        ),
        OnBoardingStep(
            titleStrId = R.string.onboarding_step2_title,
            contentStrId = R.string.onboarding_step2_content,
            lottieAnim = R.raw.photo_anim
        ),
        OnBoardingStep(
            titleStrId = R.string.onboarding_step3_title,
            contentStrId = R.string.onboarding_step3_content,
            lottieAnim = R.raw.select_anim
        ),
        OnBoardingStep(
            titleStrId = R.string.onboarding_step4_title,
            contentStrId = R.string.onboarding_step4_content,
            lottieAnim = R.raw.rate_anim
        ),
        OnBoardingStep(
            titleStrId = R.string.onboarding_step5_title,
            contentStrId = R.string.onboarding_step5_content,
            lottieAnim = R.raw.rank_anim
        )
    )

    fun onFinish() {
        viewModelScope.launch {
            setShowOnBoardingUseCase()
        }
    }
}