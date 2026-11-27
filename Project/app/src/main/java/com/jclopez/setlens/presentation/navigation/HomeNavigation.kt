package com.jclopez.setlens.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.jclopez.setlens.presentation.screen.home.HomeScreen
import com.jclopez.setlens.presentation.screen.recording.RecordingScreen
import kotlinx.serialization.Serializable

@Serializable
data object Home : NavKey

@Serializable
data object Recording : NavKey

@Composable
fun HomeNavigationHost(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(Home)

    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        entryProvider = entryProvider {
            entry<Home> {
                HomeScreen(
                    onCaptureClick = { backStack.add(Recording) },
                )
            }
            entry<Recording> {
                RecordingScreen(
                    onBack = {
                        if (backStack.size > 1) {
                            backStack.removeLast()
                        }
                    },
                )
            }
        },
    )
}
