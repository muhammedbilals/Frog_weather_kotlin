package com.inspired.frog.data.repository

import Weather
import android.util.Log
import com.inspired.frog.data.remote.WeatherApi
import com.inspired.frog.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor (private val  api:WeatherApi) :WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<Weather> {
        return try {
            val data = api.getWeatherData(lat, long)
            Log.d("Hello", "getWeatherData: $data")
            Resource.Success(
                data = data.toWeather()
            )
        }catch (e:Exception){
            e.printStackTrace()
            Log.d("Hello", "getWeatherData: Erroe = ${e.message}")
            Resource.Error(e.message?:"An Unknown Error Occurred")
        }
    }
}