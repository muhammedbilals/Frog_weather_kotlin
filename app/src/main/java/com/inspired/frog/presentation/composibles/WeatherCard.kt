package com.inspired.frog.presentation.composibles


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inspired.frog.presentation.WeatherState

@Composable
fun WeatherCard(
    state:WeatherState,
    modifier: Modifier = Modifier,
) {
    state.weatherInfo?.current?.let { data ->
        Card(
            modifier = modifier.padding(horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(id = data.weatherCode.iconRes),
                    contentDescription = "image",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = data.weatherCode.weatherDesc,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium

                )
                Spacer(modifier = Modifier.height(10.dp))

            }
        }
    }

}