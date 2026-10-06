package com.jclopez.setlens.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.jclopez.setlens.domain.usecase.RecordedSetUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel(
    recordedSetUseCase: RecordedSetUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState(recordedSets = recordedSetUseCase.getRecordedSets())
    )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onModeSelected(mode: CaptureMode) {
        _uiState.update { it.copy(selectedMode = mode) }
    }
}
