package com.jclopez.setlens.presentation.screen.recording

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jclopez.setlens.presentation.screen.recording.component.RecordingHeader
import com.jclopez.setlens.presentation.screen.recording.component.RecordingPreviewPlaceholder
import com.jclopez.setlens.presentation.theme.SetLensTheme

@Composable
fun RecordingScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    RecordingScreenContent(
        modifier = modifier,
        onBack = onBack,
    )
}

@Composable
fun RecordingScreenContent(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    preview: @Composable (Modifier) -> Unit = { RecordingPreviewPlaceholder(it) },
) {
    Box(modifier = modifier.fillMaxSize()) {
        preview(Modifier.fillMaxSize())
        RecordingHeader(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .statusBarsPadding(),
            onBack = onBack,
        )
    }
}

@Preview(name = "Recording initial surface", widthDp = 360, heightDp = 720)
@Composable
private fun RecordingScreenPreview() {
    SetLensTheme {
        RecordingScreenContent(onBack = {})
    }
}
