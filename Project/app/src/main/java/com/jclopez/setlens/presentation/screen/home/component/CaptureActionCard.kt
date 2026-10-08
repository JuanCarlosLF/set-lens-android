package com.jclopez.setlens.presentation.screen.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.jclopez.setlens.R
import com.jclopez.setlens.presentation.theme.SetLensTheme

@Composable
fun CaptureActionCard(
    isRecordingMode: Boolean,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(
            dimensionResource(R.dimen.border_width_thin),
            MaterialTheme.colorScheme.outlineVariant,
        ),
        colors = CardDefaults.cardColors().copy(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(R.dimen.padding_m),
                    vertical = dimensionResource(R.dimen.padding_l),
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Surface(
                modifier = Modifier.size(dimensionResource(R.dimen.home_action_icon_container_size)),
                shape = MaterialTheme.shapes.small,
                color = MaterialTheme.colorScheme.primaryContainer,
            ) {
                Icon(
                    imageVector = if (isRecordingMode) Icons.Default.Videocam else Icons.Default.VideoLibrary,
                    contentDescription = null,
                    modifier = Modifier.padding(dimensionResource(R.dimen.home_action_icon_padding)),
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
            Spacer(Modifier.height(dimensionResource(R.dimen.home_action_title_spacing)))
            Text(
                text = stringResource(
                    if (isRecordingMode) R.string.home_record_title else R.string.home_import_title,
                ),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
            )
            Spacer(Modifier.height(dimensionResource(R.dimen.gap_xs)))
            Text(
                text = stringResource(
                    if (isRecordingMode) {
                        R.string.home_record_description
                    } else {
                        R.string.home_import_description
                    },
                ),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Preview(name = "Record", widthDp = 360)
@Composable
private fun CaptureActionCardRecordPreview() {
    SetLensTheme {
        CaptureActionCard(
            isRecordingMode = true,
            onClick = {},
        )
    }
}

@Preview(name = "Import", widthDp = 360)
@Composable
private fun CaptureActionCardImportPreview() {
    SetLensTheme {
        CaptureActionCard(
            isRecordingMode = false,
            onClick = {},
        )
    }
}
