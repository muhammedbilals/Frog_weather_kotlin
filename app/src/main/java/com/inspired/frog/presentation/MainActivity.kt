package com.inspired.frog.presentation


import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.inspired.frog.presentation.theme.FrogWeatherAppTheme
import com.inspired.frog.presentation.ui.ui.WeatherCard

import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ))
        enableEdgeToEdge()
        setContent {
            FrogWeatherAppTheme {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                ){
                    WeatherCard(state = viewModel.state,backgroundColor = Color.Black)
                }
                if(viewModel.state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                    )
                }
                viewModel.state.error?.let { error ->
                    Text(
                        text = error,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}