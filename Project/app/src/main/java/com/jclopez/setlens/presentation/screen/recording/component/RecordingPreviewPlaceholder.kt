package com.jclopez.setlens.presentation.screen.recording.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jclopez.setlens.R
import com.jclopez.setlens.presentation.theme.SetLensTheme

@Composable
fun RecordingPreviewPlaceholder(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.recording_preview_photo),
        contentDescription = stringResource(R.string.recording_preview_placeholder),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxSize(),
    )
}

@Preview(name = "Recording preview", widthDp = 360, heightDp = 240)
@Composable
private fun RecordingPreviewPlaceholderPreview() {
    SetLensTheme {
        RecordingPreviewPlaceholder()
    }
}
