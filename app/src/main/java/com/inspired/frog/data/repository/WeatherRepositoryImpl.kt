package com.inspired.frog.data.repository

import Weather
import android.os.Build
import androidx.annotation.RequiresApi
import com.inspired.frog.data.mappers.toWeather
import com.inspired.frog.data.remote.WeatherApi
import com.inspired.frog.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<Weather> {

        return try {
            Resource.Success(data = api.getWeatherData().toWeather())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An Unknown Error Occurred")
        }
    }
}