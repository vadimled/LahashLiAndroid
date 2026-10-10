package com.lahashli.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lahashli.ui.theme.Accent
import com.lahashli.ui.theme.AppConstants
import com.lahashli.ui.theme.Surface

data class TranslationMode(
    val id: String,
    val label: String
)

@Composable
fun ModeSelector(
    selectedModeId: String,
    onModeSelect: (String) -> Unit
) {
    val modes = listOf(
        TranslationMode("ru_en", "Ru -> En"),
        TranslationMode("ru_he", "Ru -> He"),
        TranslationMode("en_ru", "En -> Ru"),
        TranslationMode("he_ru", "He -> Ru")
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = AppConstants.ModeSelectorVerticalPadding),
        contentPadding = PaddingValues(horizontal = AppConstants.ScreenPadding),
        horizontalArrangement = Arrangement.spacedBy(AppConstants.ModeSelectorHorizontalSpacing)
    ) {
        items(modes) { mode ->
            val isSelected = mode.id == selectedModeId
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(AppConstants.ModeButtonCornerRadius))
                    .background(if (isSelected) Accent else Surface)
                    .clickable { onModeSelect(mode.id) }
                    .padding(
                        horizontal = AppConstants.ModeButtonHorizontalPadding,
                        vertical = AppConstants.ModeButtonVerticalPadding
                    )
            ) {
                Text(
                    text = mode.label,
                    color = Color.White,
                    fontSize = AppConstants.ModeButtonFontSize
                )
            }
        }
    }
}
