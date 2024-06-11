package com.inspired.frog.data.dto

import Current
import CurrentUnits
import Hourly
import HourlyUnits
import Weather
import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("current")
    val current: CurrentDto?,
    @SerializedName("current_units")
    val currentUnits: CurrentUnitsDto?,
    @SerializedName("elevation")
    val elevation: Double?,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double?,
    @SerializedName("hourly")
    val hourly: HourlyDto?,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnitsDto?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String?,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int?
) {
    fun toWeather(): Weather {
        return Weather(
            current = current?.toCurrent(),
            currentUnits = currentUnits?.toCurrentUnit(),
            elevation = elevation?.toLong() ?: 0L,
            generationMs = generationtimeMs ?: 0.0,
            hourly = hourly?.toHourly() ,
            hourlyUnits = hourlyUnits?.toHourlyUnit() ,
            latitude = latitude ?: 0.0,
            longitude = longitude ?: 0.0,
            timezone = timezone ?: "",
            timezoneAbbreviation = timezoneAbbreviation ?: "",
            utcOffsetSeconds = utcOffsetSeconds?.toLong() ?: 0L
        )
    }
}

data class CurrentDto(
    @SerializedName("interval")
    val interval: Int?,
    @SerializedName("temperature_2m")
    val temperature2m: Double?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("weathercode")
    val weathercode: Int?,
    @SerializedName("wind_speed_10m")
    val windSpeed10m: Double?
) {
    fun toCurrent(): Current {
        return Current(
            windSpeed10M = windSpeed10m ?: 0.0,
            time = time ?: "",
            temperature2M = temperature2m?.toLong() ?: 0L,
            weathercode = weathercode?.toLong() ?: 0L,
            interval = interval?.toLong() ?: 0L
        )
    }
}

data class CurrentUnitsDto(
    @SerializedName("interval")
    val interval: String?,
    @SerializedName("temperature_2m")
    val temperature2m: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("weathercode")
    val weathercode: String?,
    @SerializedName("wind_speed_10m")
    val windSpeed10m: String?
) {
    fun toCurrentUnit(): CurrentUnits {
        return CurrentUnits(
            interval = interval ?: "",
            temperature2M = temperature2m ?: "",
            weathercode = weathercode ?: "",
            windSpeed10M = windSpeed10m ?: "",
            time = time ?: ""
        )
    }
}

data class HourlyDto(
    @SerializedName("relative_humidity_2m")
    val relativeHumidity2m: List<Int>?,
    @SerializedName("temperature_2m")
    val temperature2m: List<Double>?,
    @SerializedName("time")
    val time: List<String>?,
    @SerializedName("wind_speed_10m")
    val windSpeed10m: List<Double>?
) {
    fun toHourly(): Hourly {
        return Hourly(
            relativeHumidity2M = relativeHumidity2m ?: emptyList(),
            temperature2M = temperature2m ?: emptyList(),
            time = time ?: emptyList(),
            windSpeed10M = windSpeed10m ?: emptyList()
        )
    }
}

data class HourlyUnitsDto(
    @SerializedName("relative_humidity_2m")
    val relativeHumidity2m: String?,
    @SerializedName("temperature_2m")
    val temperature2m: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("wind_speed_10m")
    val windSpeed10m: String?
) {
    fun toHourlyUnit(): HourlyUnits {
        return HourlyUnits(
            time = time ?: "",
            windSpeed10M = windSpeed10m ?: "",
            temperature2M = temperature2m ?: "",
            relativeHumidity2M = relativeHumidity2m ?: ""
        )
    }
}