package com.inspired.frog.presentation.composibles

import Hourly
import Weather
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HourlyWeatherTile(modifier: Modifier = Modifier,weather: Hourly) {
    Column {
        Text(
            text = weather.time.toString(),
            fontSize = 20.sp,
            color = Color.White
        )
//        Image(
//            painter = painterResource(id = weather.iconRes),
//            contentDescription = "image",
//            modifier = Modifier
//                .width(150.dp)
//                .height(150.dp)
//        )
    }
}