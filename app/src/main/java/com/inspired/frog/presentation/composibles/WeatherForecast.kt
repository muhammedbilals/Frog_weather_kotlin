package com.inspired.frog.presentation.composibles

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.inspired.frog.presentation.WeatherState

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.hourly?.get(0)?.let {data ->
        print(data.toString())
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.Gray, RoundedCornerShape(15.dp))
                .border(1.dp, Color.Black, RoundedCornerShape(15.dp))
                .padding(10.dp)
        ) {
            LazyRow(content = {
                items(data) { weatherData ->
                    HourlyWeatherTile(
                        weather = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp).background(Color.Gray)
                    )
                }
            })
        }
    }
    
}