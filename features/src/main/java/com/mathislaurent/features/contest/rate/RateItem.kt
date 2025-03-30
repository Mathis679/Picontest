package com.mathislaurent.features.contest.rate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.mathislaurent.designsystem.ui.components.RatingBar
import com.mathislaurent.domain.entity.RatePhoto

@Composable
fun RateItem(
    photo: RatePhoto,
    onRatingChanged: (Int) -> Unit
) {
    val rating = remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(
                    vertical = 16.dp,
                    horizontal = 80.dp
                )
                .fillMaxWidth()
                .wrapContentHeight(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(photo.url)
                .crossfade(true)
                .memoryCachePolicy(CachePolicy.DISABLED)
                .diskCachePolicy(CachePolicy.DISABLED)
                .build(),
            contentDescription = "image",
            contentScale = ContentScale.Fit
        )

        RatingBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            rating = rating.value,
            onRatingChanged = { newRating ->
                rating.value = newRating
                onRatingChanged(newRating)
            }
        )
    }
}