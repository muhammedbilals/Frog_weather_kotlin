package com.inspired.frog.data.remote.mappers

import Current
import CurrentDomainModel
import Hourly
import HourlyDomainModel
import WeatherData
import WeatherInfo


fun WeatherData.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        latitude = latitude,
        longitude = longitude,
        generationTime = generationTime,
        utcOffsetSeconds = utcOffsetSeconds,
        timezone = timezone,
        timezoneAbbreviation = timezoneAbbreviation,
        elevation = elevation,
        current = current.toCurrentDomainModel(),
        hourly = hourly.toHourlyDomainModel()
    )
}

fun Current.toCurrentDomainModel(): CurrentDomainModel {
    return CurrentDomainModel(
        time = time,
        interval = interval,
        temperature = temperature,
        weatherCode = weatherCode,
        windSpeed = windSpeed
    )
}

fun Hourly.toHourlyDomainModel(): HourlyDomainModel {
    return HourlyDomainModel(
        time = time,
        temperature = temperature,
        relativeHumidity = relativeHumidity,
        windSpeed = windSpeed
    )
}
