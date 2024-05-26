package com.inspired.frog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inspired.frog.presentation.ui.ui.WeatherCard
import com.inspired.frog.presentation.theme.FrogWeatherAppTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FrogWeatherAppTheme {

                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                ){
                    WeatherCard(backgroundColor = Color.Black)
                }
            }
        }
    }
}

