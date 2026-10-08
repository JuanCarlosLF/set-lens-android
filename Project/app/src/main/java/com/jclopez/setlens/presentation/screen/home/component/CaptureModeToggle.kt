package com.jclopez.setlens.presentation.screen.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jclopez.setlens.R
import com.jclopez.setlens.presentation.screen.home.CaptureMode
import com.jclopez.setlens.presentation.theme.SetLensTheme

@Composable
fun CaptureModeToggle(
    selectedMode: CaptureMode,
    onModeSelected: (CaptureMode) -> Unit,
) {
    val modes = listOf(CaptureMode.RECORD, CaptureMode.IMPORT)
    val labels = listOf(
        R.string.home_record_mode_label,
        R.string.home_import_mode_label,
    )

    Surface(
        shape = CardDefaults.shape,
        color = MaterialTheme.colorScheme.surfaceContainer,
        border = BorderStroke(
            dimensionResource(R.dimen.border_width_thin),
            MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.2f),
        )
    ) {
        SingleChoiceSegmentedButtonRow(
            Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.home_mode_toggle_inner_padding)),
        ) {
            modes.forEachIndexed { index, mode ->
                SegmentedButton(
                    modifier = Modifier.padding(
                        horizontal = dimensionResource(R.dimen.home_mode_toggle_button_horizontal_padding),
                    ),
                    selected = selectedMode == mode,
                    onClick = { onModeSelected(mode) },
                    shape = MaterialTheme.shapes.medium,
                    colors = SegmentedButtonDefaults.colors(
                        activeContainerColor = MaterialTheme.colorScheme.surface,
                        activeContentColor = MaterialTheme.colorScheme.onSurface,
                        activeBorderColor = MaterialTheme.colorScheme.outline,
                        inactiveContainerColor = Color.Transparent,
                        inactiveContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        inactiveBorderColor = Color.Transparent,
                    ),
                    icon = {},
                    label = { Text(stringResource(labels[index])) },
                )
            }
        }
    }
}

@Preview(name = "Record", widthDp = 360)
@Composable
private fun CaptureModeToggleRecordPreview() {
    SetLensTheme {
        CaptureModeToggle(
            selectedMode = CaptureMode.RECORD,
            onModeSelected = {},
        )
    }
}

@Preview(name = "Import", widthDp = 360)
@Composable
private fun CaptureModeToggleImportPreview() {
    SetLensTheme {
        CaptureModeToggle(
            selectedMode = CaptureMode.IMPORT,
            onModeSelected = {},
        )
    }
}
