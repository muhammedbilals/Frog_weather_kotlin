package com.inspired.frog.presentation.composibles

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.inspired.frog.presentation.WeatherState

@RequiresApi(Build.VERSION_CODES.O)
@Composable


fun CurrentWeather(modifier: Modifier = Modifier,state:WeatherState,) {
    state.weatherInfo?.current?.let{ data->
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 20.dp)

        ) {
            WeatherTileRound(modifier = modifier, data)
            Column{
                WeatherTileOval(data = data)
                WeatherTileOval(data = data)
            }
        }


        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp) 
        ) {
            WeatherForecast(state = state)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                WeatherTileSquare()
                WeatherTileSquare()
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                WeatherTileSquare()
                WeatherTileSquare()
            }
        }
    }


}