package com.lahashli.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.lahashli.ui.components.Header
import com.lahashli.ui.components.ModeSelector
import com.lahashli.ui.components.RecognizedSpeechCard
import com.lahashli.ui.components.TranslationCard
import com.lahashli.ui.theme.AppConstants
import com.lahashli.ui.theme.Background
import com.lahashli.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state by viewModel.uiState.collectAsState()

    val topBarContent = @Composable {
        Header(
            isRecording = state.isRecording,
            onMicClick = {
                if (state.isRecording) viewModel.onStopRecording()
                else viewModel.onStartRecording()
            }
        )
    }

    Scaffold(
        topBar = topBarContent,
        containerColor = Background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            ModeSelector(
                selectedModeId = state.selectedModeId,
                onModeSelect = { viewModel.onModeSelect(it) }
            )

            RecognizedSpeechCard(
                text = state.transcript
            )

            Spacer(modifier = Modifier.height(AppConstants.ItemSpacing))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = AppConstants.ListBottomPadding)
            ) {
                items(state.translations.toList()) { (lang, text) ->
                    TranslationCard(
                        language = lang,
                        translation = text,
                        onCopy = { viewModel.onCopyText(text) },
                        onPlay = { viewModel.onPlayText(text) }
                    )
                }
            }
        }
    }
}
