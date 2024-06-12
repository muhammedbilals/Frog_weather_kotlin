package com.inspired.frog.data.remote
import com.inspired.frog.data.dto.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
@GET("https://api.open-meteo.com/v1/forecast?latitude=25.0772&longitude=55.3093&current=temperature_2m,relative_humidity_2m,apparent_temperature,is_day,precipitation,weather_code,wind_speed_10m&hourly=temperature_2m,weather_code&daily=weather_code,sunrise,sunset,uv_index_max")

    suspend fun getWeatherData(): WeatherDto
}


//@GET("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,weathercode,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m")
