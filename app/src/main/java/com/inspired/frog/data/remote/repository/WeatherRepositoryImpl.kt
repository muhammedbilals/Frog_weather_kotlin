package com.inspired.frog.data.remote.repository

import WeatherInfo
import com.inspired.frog.data.remote.WeatherApi
import com.inspired.frog.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource

class WeatherRepositoryImpl @Inject constructor (private val  api:WeatherApi) :WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        TODO("Not yet implemented")
    }
}