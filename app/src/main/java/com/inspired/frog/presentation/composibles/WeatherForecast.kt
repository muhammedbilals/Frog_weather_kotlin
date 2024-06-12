package com.inspired.frog.presentation.composibles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inspired.frog.presentation.WeatherState

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.hourly?.let {data ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

        }
    }
    
}