package com.jclopez.setlens.presentation.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jclopez.setlens.presentation.theme.SetLensTheme

private data class SavedSeries(
    val id: String,
    val date: String,
    val title: String,
    val rpe: String,
    val subtitle: String,
    val loadAndReps: String,
    val duration: String,
    val thumbnailIcon: ImageVector
)

private val savedSeries = listOf(
    SavedSeries(
        id = "squat-today",
        date = "Hoy · 10:45",
        title = "Sentadilla trasera",
        rpe = "RPE 8.5",
        subtitle = "Serie 3 · Efectiva",
        loadAndReps = "160 kg × 3",
        duration = "0:18",
        thumbnailIcon = Icons.Default.FitnessCenter
    ),
    SavedSeries(
        id = "bench-yesterday",
        date = "Ayer · 18:20",
        title = "Press de banca",
        rpe = "RPE 9",
        subtitle = "Top set",
        loadAndReps = "115 kg × 2",
        duration = "0:14",
        thumbnailIcon = Icons.Default.Videocam
    ),
    SavedSeries(
        id = "deadlift-september",
        date = "22 Sep · 12:15",
        title = "Peso muerto convencional",
        rpe = "RPE 8",
        subtitle = "Single de calibración",
        loadAndReps = "200 kg × 1",
        duration = "0:22",
        thumbnailIcon = Icons.Default.FitnessCenter
    ),
    SavedSeries(
        id = "press-september",
        date = "20 Sep · 17:30",
        title = "Press militar",
        rpe = "RPE 7.5",
        subtitle = "Back-off 1",
        loadAndReps = "70 kg × 5",
        duration = "0:16",
        thumbnailIcon = Icons.Default.VideoLibrary
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    onSettingsClick: () -> Unit = {},
) {
    var selectedMode by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lift Library") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                actions = {
                    IconButton(onClick = onSettingsClick) {
                        Icon(Icons.Default.Settings, contentDescription = "Ajustes")
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
                start = 16.dp,
                top = 8.dp,
                end = 16.dp,
                bottom = 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item(key = "mode-toggle") {
                CaptureModeToggle(
                    selectedMode = selectedMode,
                    onModeSelected = { selectedMode = it }
                )
            }
            item(key = "capture-action") {
                CaptureActionCard(isRecordingMode = selectedMode == 0)
            }
            item(key = "saved-header") {
                SavedSeriesHeader()
            }
            items(savedSeries, key = { it.id }) { series ->
                SavedSeriesCard(series)
            }
        }
    }
}

@Composable
private fun CaptureModeToggle(
    selectedMode: Int,
    onModeSelected: (Int) -> Unit
) {
    val labels = listOf("Grabar", "Importar")

    SingleChoiceSegmentedButtonRow(Modifier.fillMaxWidth()) {
        labels.forEachIndexed { index, label ->
            SegmentedButton(
                selected = selectedMode == index,
                onClick = { onModeSelected(index) },
                shape = SegmentedButtonDefaults.itemShape(index, labels.size),
                icon = {},
                label = { Text(label) }
            )
        }
    }
}

@Composable
private fun CaptureActionCard(isRecordingMode: Boolean) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(96.dp),
                shape = MaterialTheme.shapes.small,
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Icon(
                    imageVector = if (isRecordingMode) {
                        Icons.Default.Videocam
                    } else {
                        Icons.Default.VideoLibrary
                    },
                    contentDescription = null,
                    modifier = Modifier.padding(20.dp),
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            Spacer(Modifier.height(12.dp))
            Text(
                text = if (isRecordingMode) "Grabar una serie" else "Seleccionar un vídeo",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = if (isRecordingMode) {
                    "Toca para abrir cámara y ajustar encuadre"
                } else {
                    "Selecciona un vídeo de tu galería"
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun SavedSeriesHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Series guardadas 4",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        FilterChip(
            selected = false,
            onClick = { },
            colors = FilterChipDefaults.filterChipColors().copy(
                labelColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary
            ),
            label = { Text("Filtros") }
        )
    }
}

@Composable
private fun SavedSeriesCard(series: SavedSeries) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SeriesThumbnail(series)
            Spacer(Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterStart),
                        text = series.date,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Text(
                    text = series.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = series.subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f, fill = false)
                    )
                }
                Text(
                    text = series.loadAndReps,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Box(modifier = Modifier.fillMaxHeight()) {
                Surface(
                    modifier = Modifier.align(Alignment.TopEnd),
                    shape = MaterialTheme.shapes.small,
                    color = MaterialTheme.colorScheme.tertiaryContainer
                ) {
                    Text(
                        text = series.rpe,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }
                Icon(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.Center),
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant

                )
            }

        }
    }
}

@Composable
private fun SeriesThumbnail(series: SavedSeries) {
    Surface(
        modifier = Modifier.size(84.dp),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.surface
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Icon(
                imageVector = series.thumbnailIcon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.Center)
            )
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(4.dp),
                shape = MaterialTheme.shapes.extraSmall,
                color = MaterialTheme.colorScheme.scrim.copy(alpha = 0.65f)
            ) {
                Text(
                    text = series.duration,
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.inverseOnSurface
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    SetLensTheme {
        HomeScreen(modifier = Modifier)
    }
}
