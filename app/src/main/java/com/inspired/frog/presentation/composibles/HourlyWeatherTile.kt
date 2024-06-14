package com.inspired.frog.presentation.composibles

import Hourly
import Weather
import android.os.Build
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HourlyWeatherTile(modifier: Modifier = Modifier,weather: Hourly) {
    val formattedTime = remember(weather) {
        weather.time.format(DateTimeFormatter.ofPattern("h a"))
    }

    Column(
        modifier = modifier
            .padding(horizontal = 2.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(
            text = formattedTime.uppercase(Locale.ROOT),
            fontSize = 12.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(5.dp))
        Image(
            painter = painterResource(id = weather.weatherCode.iconRes),
            contentDescription = "image",
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))


        Text(
            text = weather.temperature2M.toString(),
            fontSize = 12.sp,
            color = Color.White
        )
    }
}