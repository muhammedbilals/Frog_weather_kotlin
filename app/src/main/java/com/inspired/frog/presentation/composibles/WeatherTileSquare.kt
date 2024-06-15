package com.inspired.frog.presentation.composibles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun WeatherTileSquare(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(180.dp)
            .padding(5.dp)
            .background(Color.White, shape = RoundedCornerShape(percent = 10)),
    ) {

    }
}