package com.manoj.wrkspot.presentation.ui

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.manoj.wrkspot.R

@Composable
fun ImageFromURL(url: String) {
    AsyncImage(
        model = url,
        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        error = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "The design logo",
        modifier = Modifier.size(60.dp)
    )
}