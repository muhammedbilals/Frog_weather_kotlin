package com.inspired.frog.data.remote
import com.inspired.frog.data.dto.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
@GET("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,weathercode,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m")
    suspend fun getWeatherData(): WeatherDto
}