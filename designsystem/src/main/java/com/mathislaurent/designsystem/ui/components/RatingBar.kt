package com.mathislaurent.designsystem.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mathislaurent.designsystem.ui.theme.PicontestTheme

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Int,
    maxRating: Int = 5,
    onRatingChanged: (Int) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 1..maxRating) {
            IconButton(onClick = { onRatingChanged(i) }) {
                if (i <= rating) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Remove"
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.StarBorder,
                        contentDescription = "Remove"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PicontestTheme {
        RatingBar(
            rating = 3,
            onRatingChanged = {}
        )
    }
}