package com.inspired.frog.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("current")
    val current: CurrentDto,
    @SerializedName("hourly")
    val hourly: HourlyDto,
    @SerializedName("daily")
    val daily: DailyDto
)

data class CurrentDto(
    @SerializedName("time")
    val time: String?,
    @SerializedName("temperature_2m")
    val temperature2M: Double?,
    @SerializedName("relative_humidity_2m")
    val relativeHumidity2M: Double?,
    @SerializedName("apparent_temperature")
    val apparentTemperature: Double?,
    @SerializedName("is_day")
    val isDay: Int?,
    @SerializedName("precipitation")
    val precipitation: Double?,
    @SerializedName("weather_code")
    val weatherCode: Int?,
    @SerializedName("wind_speed_10m")
    val windSpeed10M: Double?
)

data class DailyDto(
    @SerializedName("time")
    val time: List<String>?,
    @SerializedName("weather_code")
    val weatherCode: List<Int>,
    @SerializedName("sunrise")
    val sunrise: List<String>?,
    @SerializedName("sunset")
    val sunset: List<String>?,
    @SerializedName("uv_index_max")
    val uvIndexMax: List<Double>
)

data class HourlyDto(
    @SerializedName("time")
    val time: List<String>?,
    @SerializedName("temperature_2m")
    val temperature2M: List<Double>?,
    @SerializedName("weather_code")
    val weatherCode: List<Int>?
)
