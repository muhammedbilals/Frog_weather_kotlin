package com.inspired.frog.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.location.Geocoder
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.inspired.frog.presentation.composibles.CurrentWeather
import com.inspired.frog.presentation.composibles.WeatherCard
import com.inspired.frog.presentation.composibles.WeatherForecast
import com.inspired.frog.presentation.theme.Black
import com.inspired.frog.presentation.theme.FrogWeatherAppTheme
import com.inspired.frog.presentation.theme.Roboto
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "MissingPermission")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val locationName = mutableStateOf("")

        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location : Location? ->
                    // Got last known location. In some rare situations this can be null.
                    if(location!=null){
                        Log.d("location",location.toString())
                        val geocoder = Geocoder(this, Locale.getDefault())
                        try {
                            val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                            if (addresses != null) {
                                if (addresses.isNotEmpty()) {
                                    val address = addresses[0]
                                     locationName.value = address.locality // You can also use address.locality, address.adminArea, etc.
                                    Log.d("location", "Location Name: ${locationName.value}")
                                } else {
                                    Log.d("location", "No address found for location")
                                }
                            }
                        } catch (e: IOException) {
                            Log.d("location", "Geocoder failed", e)
                        }
                    }
                }
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            )
        )
         fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        enableEdgeToEdge()
        setContent {
            FrogWeatherAppTheme {
              Scaffold(
                  //top appbar
                  topBar = {
                      CenterAlignedTopAppBar(title = { Text(text = locationName.value, style =  MaterialTheme.typography.titleMedium )})
                  },
                  containerColor = MaterialTheme.colorScheme.background,
                  modifier = Modifier.fillMaxSize()
                  
              )  {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black)
                    ) {
                        item { Spacer(modifier = Modifier.height(150.dp)) }
                        item { WeatherCard(state = viewModel.state) }
                        item { CurrentWeather(state = viewModel.state) }
                        item { Spacer(modifier = Modifier.height(40.dp)) }
                        
                        item {
                            if (viewModel.state.isLoading) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    CircularProgressIndicator()
                                }
                            }
                        }
                        viewModel.state.error?.let { error ->
                            item {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxSize()
                                ) {
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
            }
        }
    }
}
