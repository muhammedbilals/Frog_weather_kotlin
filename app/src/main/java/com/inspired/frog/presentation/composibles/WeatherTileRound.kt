package com.inspired.frog.presentation.composibles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.ui.tooling.preview.Preview


@Composable

fun WeatherTileRound(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(190.dp).padding(10.dp)// Adjust size as needed
            .background(Color.White, shape = CircleShape),
        contentAlignment = Alignment.Center
    ){

    }
}