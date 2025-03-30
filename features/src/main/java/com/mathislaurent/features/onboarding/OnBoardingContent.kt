package com.mathislaurent.features.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mathislaurent.designsystem.ui.components.PTButton
import com.mathislaurent.designsystem.ui.theme.PicontestTheme
import com.mathislaurent.features.R
import kotlinx.coroutines.launch

@Composable
fun OnBoardingContent(
    list: List<OnBoardingViewModel.OnBoardingStep>,
    onFinish: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { list.size })
    val isLastStep = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            isLastStep.value = page == (list.size - 1)
        }
    }


    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            HorizontalPager(
                modifier = Modifier.fillMaxWidth(),
                state = pagerState
            ) { position ->
                OnBoardingStep(
                    step = list[position]
                )
            }

            PTButton(
                modifier = Modifier.fillMaxWidth(),
                text = if (isLastStep.value) {
                    stringResource(R.string.onboarding_finish)
                } else {
                    stringResource(R.string.onboarding_continue)
                },
                onClick = {
                    if (isLastStep.value) {
                        onFinish()
                    } else {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PicontestTheme {
        OnBoardingContent(
            list = listOf(),
            onFinish = {}
        )
    }
}

