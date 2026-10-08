package com.jclopez.setlens.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jclopez.setlens.R
import com.jclopez.setlens.domain.model.RecordedSet
import com.jclopez.setlens.presentation.screen.home.component.CaptureActionCard
import com.jclopez.setlens.presentation.screen.home.component.CaptureModeToggle
import com.jclopez.setlens.presentation.screen.home.component.SavedSeriesCard
import com.jclopez.setlens.presentation.screen.home.component.SavedSeriesHeader
import com.jclopez.setlens.presentation.theme.SetLensTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onSettingsClick: () -> Unit = {},
    onCaptureClick: () -> Unit = {},
    onFilterClick: () -> Unit = {},
    onRecordedSetClick: (RecordedSet) -> Unit = {},
    viewModel: HomeViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreenContent(
        modifier = modifier,
        uiState = uiState,
        onModeSelected = viewModel::onModeSelected,
        onSettingsClick = onSettingsClick,
        onCaptureClick = onCaptureClick,
        onFilterClick = onFilterClick,
        onRecordedSetClick = onRecordedSetClick,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    uiState: HomeUiState,
    modifier: Modifier = Modifier,
    onModeSelected: (CaptureMode) -> Unit = {},
    onSettingsClick: () -> Unit = {},
    onCaptureClick: () -> Unit = {},
    onFilterClick: () -> Unit = {},
    onRecordedSetClick: (RecordedSet) -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.home_title)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                actions = {
                    IconButton(onClick = onSettingsClick) {
                        Icon(
                            Icons.Default.Settings,
                            contentDescription = stringResource(R.string.home_settings_description),
                        )
                    }
                }
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(
                start = dimensionResource(R.dimen.padding_s),
                top = dimensionResource(R.dimen.padding_xs),
                end = dimensionResource(R.dimen.padding_s),
                bottom = dimensionResource(R.dimen.padding_l),
            ),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.gap_m)),
        ) {
            item(key = "toggle-mode") {
                CaptureModeToggle(
                    selectedMode = uiState.selectedMode,
                    onModeSelected = onModeSelected,
                )
            }
            item(key = "capture-action") {
                CaptureActionCard(
                    isRecordingMode = uiState.selectedMode == CaptureMode.RECORD,
                    onClick = onCaptureClick,
                )
            }
            item(key = "saved-header") {
                SavedSeriesHeader(
                    recordedSetCount = uiState.recordedSets.size,
                    onFilterClick = onFilterClick,
                )
            }
            items(
                items = uiState.recordedSets,
                key = { it.id.toString() },
            ) { recordedSet ->
                SavedSeriesCard(
                    recordedSet = recordedSet,
                    onClick = { onRecordedSetClick(recordedSet) },
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenContentPreview() {
    SetLensTheme {
        HomeScreenContent(uiState = HomeUiState())
    }
}
