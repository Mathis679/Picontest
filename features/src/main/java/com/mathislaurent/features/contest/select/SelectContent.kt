package com.mathislaurent.features.contest.select

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mathislaurent.designsystem.ui.components.PTButton
import com.mathislaurent.features.R
import java.io.File

@Composable
fun SelectContent(
    uiState: SelectViewModel.ContestUiState.Images,
    onClose: () -> Unit,
    onValidate: (File) -> Unit
) {
    val selectedItem = remember {
        mutableStateOf<File?>(null)
    }
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
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
                    text = stringResource(R.string.select_title),
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

            if (uiState.list.isEmpty()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.select_no_image),
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                LazyVerticalGrid(
                    modifier = Modifier
                        .weight(1F),
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(uiState.list) { imageFile ->
                        ImageItem(
                            imageFile = imageFile,
                            isSelected = false,
                            onClick = {
                                selectedItem.value = imageFile
                            }
                        )
                    }
                }
            }

            selectedItem.value?.let { file ->
                PTButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.select_validate),
                    onClick = {
                        onValidate(file)
                    }
                )
            }
        }
    }
}