package com.jclopez.setlens.presentation.screen.recording.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.jclopez.setlens.R
import com.jclopez.setlens.presentation.screen.component.BackButton
import com.jclopez.setlens.presentation.theme.SetLensTheme

@Composable
fun RecordingHeader(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(R.dimen.padding_s),
                vertical = dimensionResource(R.dimen.gap_s),
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BackButton(onClick = onBack)
    }
}

@Preview(name = "Recording header", widthDp = 360, heightDp = 64)
@Composable
private fun RecordingHeaderPreview() {
    SetLensTheme {
        RecordingHeader(onBack = {})
    }
}
