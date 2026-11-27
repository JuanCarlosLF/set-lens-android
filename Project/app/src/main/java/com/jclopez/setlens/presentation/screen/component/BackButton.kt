package com.jclopez.setlens.presentation.screen.component

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jclopez.setlens.R
import com.jclopez.setlens.presentation.theme.SetLensTheme

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    FilledIconButton(
        onClick = onClick,
        modifier = modifier
            .widthIn(min = dimensionResource(R.dimen.back_button_min_width))
            .heightIn(min = dimensionResource(R.dimen.back_button_min_height)),
        shape = MaterialTheme.shapes.extraLarge,
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.85f),
            contentColor = MaterialTheme.colorScheme.primary,
        ),
    ) {
        Icon(
            modifier = Modifier.size(dimensionResource(R.dimen.icon_size_medium)),
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back_description),
            tint = MaterialTheme.colorScheme.primary,
        )
    }
}

@Preview
@Composable
private fun BackButtonPreview() {
    SetLensTheme {
        BackButton(onClick = {})
    }
}
