package com.inspired.frog.data.remote.Mappers

import Current
import CurrentDomainModel
import Hourly
import HourlyDomainModel
import WeatherData
import WeatherInfo

object WeatherDataMapper {

    fun mapToDomain(weatherData: WeatherData): WeatherInfo {
        return WeatherInfo(
            latitude = weatherData.latitude,
            longitude = weatherData.longitude,
            generationTime = weatherData.generationTime,
            utcOffsetSeconds = weatherData.utcOffsetSeconds,
            timezone = weatherData.timezone,
            timezoneAbbreviation = weatherData.timezoneAbbreviation,
            elevation = weatherData.elevation,
            current = mapCurrentToDomain(weatherData.current),
            hourly = mapHourlyToDomain(weatherData.hourly)
        )
    }

    private fun mapCurrentToDomain(current: Current): CurrentDomainModel {
        return CurrentDomainModel(
            time = current.time,
            interval = current.interval,
            temperature = current.temperature,
            weatherCode = current.weatherCode,
            windSpeed = current.windSpeed
        )
    }

    private fun mapHourlyToDomain(hourly: Hourly): HourlyDomainModel {
        return HourlyDomainModel(
            time = hourly.time,
            temperature = hourly.temperature,
            relativeHumidity = hourly.relativeHumidity,
            windSpeed = hourly.windSpeed
        )
    }
}
