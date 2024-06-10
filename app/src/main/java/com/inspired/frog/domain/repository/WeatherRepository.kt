package com.inspired.frog.domain.repository

import WeatherInfo
import com.plcoding.weatherapp.domain.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat :Double,long:Double):Resource<WeatherInfo>
}