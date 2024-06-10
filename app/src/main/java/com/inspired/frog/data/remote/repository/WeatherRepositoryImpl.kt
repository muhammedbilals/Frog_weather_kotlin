package com.inspired.frog.data.remote.repository

import WeatherInfo
import com.inspired.frog.data.remote.WeatherApi
import com.inspired.frog.data.remote.mappers.toWeatherInfo
import com.inspired.frog.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor (private val  api:WeatherApi) :WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(lat=lat,long=long).toWeatherInfo()
            )
        }catch (e:Exception){
            e.printStackTrace()
            Resource.Error(e.message?:"An Unknown Error Occurred")

        }
    }
}