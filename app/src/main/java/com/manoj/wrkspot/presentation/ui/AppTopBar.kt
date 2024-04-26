package com.manoj.wrkspot.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    backGroundColor: Color = MaterialTheme.colorScheme.primary,
    elevation: Dp = 4.dp,
    borderStroke: Dp = 1.dp,
    borderColor: Color = Color.Gray,
    text: String
) {
    Surface(
        color = backGroundColor,
        tonalElevation = elevation,
        border = BorderStroke(borderStroke, borderColor)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "$text   Today's Date:" + SimpleDateFormat(
                        "yyyy-MM-dd",
                        Locale.getDefault()
                    ).format(
                        Date()
                    ),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        )
    }
}