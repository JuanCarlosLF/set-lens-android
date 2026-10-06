package com.jclopez.setlens.presentation.screen.home

import com.jclopez.setlens.domain.model.RecordedSet

enum class CaptureMode {
    RECORD,
    IMPORT
}

data class HomeUiState(
    val selectedMode: CaptureMode = CaptureMode.RECORD,
    val recordedSets: List<RecordedSet> = emptyList()
)
