package com.jclopez.setlens.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Green90,
    onPrimary = Green35,
    primaryContainer = Green35,
    onPrimaryContainer = Green90,
    background = Neutral10,
    onBackground = Green95,
    surface = Neutral20,
    onSurface = Green95,
    onSurfaceVariant = Neutral80,
    surfaceContainer = Neutral25,
    outline = Neutral60,
    outlineVariant = Neutral40,
    inverseSurface = Green95,
    inverseOnSurface = Neutral20,
)

private val LightColorScheme = lightColorScheme(
    primary = Green45,
    onPrimary = White,
    primaryContainer = Green98,
    onPrimaryContainer = Green35,
    background = Neutral95,
    onBackground = Slate10,
    surface = White,
    onSurface = Slate10,
    onSurfaceVariant = Slate45,
    surfaceContainer = Neutral85,
    outline = Slate45,
    outlineVariant = Neutral80,
    inverseSurface = Slate10,
    inverseOnSurface = White,
)

@Composable
fun SetLensTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
