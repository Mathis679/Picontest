package com.mathislaurent.features.contest.rate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.mathislaurent.designsystem.ui.components.PCLoader
import com.mathislaurent.designsystem.ui.components.PTButton
import com.mathislaurent.designsystem.ui.theme.PicontestTheme
import com.mathislaurent.domain.entity.RatePhoto
import com.mathislaurent.features.R
import kotlinx.coroutines.launch

@Composable
fun RateContent(
    uiState: RateViewModel.RateUiState,
    onClose: () -> Unit,
    onRatingChanged: (Int, RatePhoto) -> Unit
) {

    Scaffold { innerPadding ->
        when (uiState) {
            RateViewModel.RateUiState.Loading -> {
                PCLoader(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            is RateViewModel.RateUiState.Success -> {
                PagerRateContent(
                    modifier = Modifier
                        .padding(innerPadding),
                    list = uiState.list,
                    onClose = onClose,
                    onRatingChanged = onRatingChanged
                )
            }
        }

    }
}

@Composable
fun PagerRateContent(
    modifier: Modifier = Modifier,
    list: List<RatePhoto>,
    onClose: () -> Unit,
    onRatingChanged: (Int, RatePhoto) -> Unit
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

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.rate_title),
                style = MaterialTheme.typography.titleMedium
            )
            IconButton(
                onClick = {
                    onClose()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close"
                )
            }
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            text = stringResource(R.string.rate_subtitle),
            style = MaterialTheme.typography.bodyLarge
        )

        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F),
            userScrollEnabled = false,
            state = pagerState
        ) { position ->
            RateItem(
                photo = list[position],
                onRatingChanged = { newRating ->
                    onRatingChanged(
                        newRating,
                        list[position]
                    )
                }
            )
        }

        PTButton(
            modifier = Modifier.fillMaxWidth(),
            text = if (isLastStep.value) {
                stringResource(R.string.rate_finish)
            } else {
                stringResource(R.string.rate_continue)
            },
            onClick = {
                if (isLastStep.value) {
                    onClose()
                } else {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            }
        )
    }
}

@Preview
@Composable
private fun Preview() {
    PicontestTheme {
        PagerRateContent(
            list = emptyList(),
            onClose = {},
            onRatingChanged = {_,_->}
        )
    }
}