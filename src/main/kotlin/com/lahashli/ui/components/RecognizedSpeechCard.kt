package com.lahashli.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lahashli.ui.theme.AppConstants
import com.lahashli.ui.theme.BackgroundSecondary
import com.lahashli.ui.theme.TextMuted
import com.lahashli.ui.theme.TextPrimary

@Composable
fun RecognizedSpeechCard(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppConstants.ScreenPadding,
                vertical = AppConstants.CardOuterPaddingVertical
            )
            .clip(RoundedCornerShape(AppConstants.CardCornerRadius))
            .background(BackgroundSecondary)
            .padding(AppConstants.CardInnerPadding)
    ) {
        if (text.isEmpty()) {
            Text(
                text = "Начните говорить...",
                color = TextMuted,
                fontSize = AppConstants.PlaceholderFontSize
            )
        } else {
            Text(
                text = text,
                color = TextPrimary,
                fontSize = AppConstants.TranscriptFontSize
            )
        }
    }
}
