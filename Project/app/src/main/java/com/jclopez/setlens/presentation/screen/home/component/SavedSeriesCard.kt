package com.jclopez.setlens.presentation.screen.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.jclopez.setlens.R
import com.jclopez.setlens.domain.model.Exercise
import com.jclopez.setlens.domain.model.RecordedSet
import com.jclopez.setlens.presentation.theme.SetLensTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

@Composable
fun SavedSeriesCard(
    recordedSet: RecordedSet,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(
            dimensionResource(R.dimen.border_width_thin),
            MaterialTheme.colorScheme.outlineVariant,
        ),
        colors = CardDefaults.cardColors().copy(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(dimensionResource(R.dimen.home_series_card_content_padding)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SeriesThumbnail(durationSeconds = recordedSet.durationSeconds)
            Spacer(Modifier.width(dimensionResource(R.dimen.gap_m)))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(R.dimen.home_series_card_text_spacing),
                ),
            ) {
                Text(
                    text = formatRecordedAt(recordedSet.recordedAtEpochMillis),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Text(
                    text = recordedSet.exercise.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = stringResource(
                        R.string.home_load_repetitions_format,
                        formatNumber(recordedSet.loadKg),
                        recordedSet.repetitions.toString(),
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
            Box(modifier = Modifier.fillMaxHeight()) {
                recordedSet.rpe?.let { rpe ->
                    Surface(
                        modifier = Modifier.align(Alignment.TopEnd),
                        shape = MaterialTheme.shapes.small,
                        color = MaterialTheme.colorScheme.primaryContainer,
                    ) {
                        Text(
                            text = stringResource(R.string.home_rpe_label, formatNumber(rpe)),
                            modifier = Modifier.padding(
                                horizontal = dimensionResource(
                                    R.dimen.home_series_card_badge_horizontal_padding,
                                ),
                                vertical = dimensionResource(
                                    R.dimen.home_series_card_badge_vertical_padding,
                                ),
                            ),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                    }
                }
                Icon(
                    modifier = Modifier
                        .padding(start = dimensionResource(R.dimen.gap_s))
                        .align(Alignment.Center),
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}

private fun formatRecordedAt(epochMillis: Long): String =
    SimpleDateFormat("dd MMM yyyy · HH:mm", Locale.getDefault()).format(Date(epochMillis))

private fun formatNumber(value: Double): String =
    if (value % 1.0 == 0.0) value.toLong().toString() else value.toString()

@Preview(widthDp = 360)
@Composable
private fun SavedSeriesCardPreview() {
    val sampleExercise = Exercise(
        id = UUID.fromString("11111111-1111-1111-1111-111111111111"),
        name = "Press de banca",
    )
    val sampleRecordedSet = RecordedSet(
        id = UUID.fromString("22222222-2222-2222-2222-222222222222"),
        exercise = sampleExercise,
        loadKg = 80.0,
        repetitions = 8,
        rpe = 8.0,
        recordedAtEpochMillis = 1_700_000_000_000L,
        durationSeconds = 92L,
    )

    SetLensTheme {
        SavedSeriesCard(
            recordedSet = sampleRecordedSet,
            onClick = {},
        )
    }
}
