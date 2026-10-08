package com.jclopez.setlens.presentation.screen.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.jclopez.setlens.R
import com.jclopez.setlens.presentation.theme.SetLensTheme
import java.util.Locale

@Composable
fun SeriesThumbnail(durationSeconds: Long) {
    Surface(
        modifier = Modifier.size(dimensionResource(R.dimen.home_series_thumbnail_size)),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Icon(
                imageVector = Icons.Default.FitnessCenter,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.home_series_thumbnail_icon_size))
                    .align(Alignment.Center),
            )
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(dimensionResource(R.dimen.gap_xs)),
                shape = MaterialTheme.shapes.extraSmall,
                color = MaterialTheme.colorScheme.inverseSurface.copy(alpha = 0.65f),
            ) {
                Text(
                    text = formatDuration(durationSeconds),
                    modifier = Modifier.padding(
                        horizontal = dimensionResource(
                            R.dimen.home_series_thumbnail_badge_horizontal_padding,
                        ),
                        vertical = dimensionResource(
                            R.dimen.home_series_thumbnail_badge_vertical_padding,
                        ),
                    ),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.inverseOnSurface,
                )
            }
        }
    }
}

private fun formatDuration(durationSeconds: Long): String =
    "%d:%02d".format(Locale.ROOT, durationSeconds / 60, durationSeconds % 60)

@Preview
@Composable
private fun SeriesThumbnailPreview() {
    SetLensTheme {
        SeriesThumbnail(durationSeconds = 92L)
    }
}
