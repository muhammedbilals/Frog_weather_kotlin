package com.inspired.frog.presentation

import Weather

data class WeatherState(
    val weatherInfo: Weather? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
