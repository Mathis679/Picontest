package com.mathislaurent.features.home.ranking

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mathislaurent.designsystem.ui.components.PCLoader
import com.mathislaurent.features.R

@Composable
fun RankingContent(
    modifier: Modifier = Modifier,
    uiState: RankingViewModel.RankingUiState
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
            text = stringResource(R.string.ranking_title),
            style = MaterialTheme.typography.titleMedium
        )

        when (uiState) {
            RankingViewModel.RankingUiState.Loading -> {
                PCLoader(
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            is RankingViewModel.RankingUiState.Success -> {
                val pagerState = rememberPagerState(pageCount = { uiState.list.size })
                HorizontalPager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1F),
                    state = pagerState
                ) { position ->
                    RankItem(
                        photo = uiState.list[position]
                    )
                }
            }
        }
    }
}