package com.lahashli.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HomeState(
    val transcript: String = "",
    val isRecording: Boolean = false,
    val selectedModeId: String = "ru_en",
    val translations: Map<String, String> = emptyMap(),
    val errorMessage: String? = null
)

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    fun onStartRecording() {
        _uiState.value = _uiState.value.copy(isRecording = true, errorMessage = null)
    }

    fun onStopRecording() {
        _uiState.value = _uiState.value.copy(isRecording = false)
    }

    fun onModeSelect(modeId: String) {
        _uiState.value = _uiState.value.copy(selectedModeId = modeId)
    }

    fun onCopyText(text: String) {
        // Will be implemented later
    }

    fun onPlayText(text: String) {
        // Will be implemented later
    }
}
