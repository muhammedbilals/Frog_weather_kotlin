package com.inspired.frog.presentation.composibles

import Current
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.util.TableInfo
import com.inspired.frog.presentation.WeatherState
import com.inspired.frog.presentation.theme.Black
import com.inspired.frog.presentation.theme.White


@Composable

fun WeatherTileRound(modifier: Modifier = Modifier,data:Current) {
    Box(
        modifier = Modifier
            .size(190.dp)
            .padding(10.dp)// Adjust size as needed
            .background(White, shape = CircleShape),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
        ) {
            Text(
                text = "${data.temperature2M}°",
                modifier = modifier,
                style = MaterialTheme.typography.displayMedium,
                color = Black

            )
        }
    }
}