package com.jclopez.setlens.presentation.screen.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.jclopez.setlens.R
import com.jclopez.setlens.presentation.theme.SetLensTheme

@Composable
fun SavedSeriesHeader(
    recordedSetCount: Int,
    onFilterClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(R.string.home_series_title, recordedSetCount.toString()),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
        )
        FilterChip(
            selected = false,
            onClick = onFilterClick,
            colors = FilterChipDefaults.filterChipColors().copy(
                labelColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            label = { Text(stringResource(R.string.home_filter_label)) },
        )
    }
}

@Preview(widthDp = 360)
@Composable
private fun SavedSeriesHeaderPreview() {
    SetLensTheme {
        SavedSeriesHeader(
            recordedSetCount = 3,
            onFilterClick = {},
        )
    }
}
