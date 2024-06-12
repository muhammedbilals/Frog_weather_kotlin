package com.inspired.frog.data.mappers

import Current
import Daily
import Hourly
import Weather
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.inspired.frog.data.dto.CurrentDto
import com.inspired.frog.data.dto.DailyDto
import com.inspired.frog.data.dto.HourlyDto
import com.inspired.frog.data.dto.WeatherDto
import com.plcoding.weatherapp.domain.weather.WeatherType
import java.time.OffsetDateTime


private data class  IndexedHourlyData(
    val index: Int,
    val data:Hourly
)
@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWeather(): Weather {
    return Weather(
        latitude = latitude ?: 0.0,
        longitude = longitude ?: 0.0,
        current = current.toCurrent(),
        hourly = hourly.toHourly(),
        daily = daily.toDaily(),
    )
}


@RequiresApi(Build.VERSION_CODES.O)
fun CurrentDto.toCurrent(): Current {
    return Current(
        time = OffsetDateTime.parse(time),
        temperature2M = temperature2M ?: 0.0,
        relativeHumidity2M = relativeHumidity2M ?: 0.0,
        apparentTemperature = apparentTemperature ?: 0.0,
        isDay = when (isDay) {
            1 -> true
            2 -> false
            else -> false},
        precipitation = precipitation ?: 0.0,
        weatherCode = WeatherType.fromWMO(weatherCode?:0),
        windSpeed10M = windSpeed10M ?: 0.0
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun HourlyDto.toHourly(): Map<Int, List<Hourly>> {
    return time?.mapIndexed { index, time ->
        val temperature = temperature2M?.get(index) ?: 0.0 // Provide a default value of 0.0 if null
        val weatherCode = weatherCode?.get(index)

        IndexedHourlyData(
            index,
            Hourly(
                time = OffsetDateTime.parse(time),
                temperature2M = temperature,
                weatherCode = WeatherType.fromWMO(weatherCode?.toInt() ?: 0) // Provide a default value of 0 if null
            )
        )
    }?.groupBy {
        it.index/24
    }?.mapValues {
        it.value.map {
            it.data
        }
    } ?: emptyMap<Int, List<Hourly>>().also {
        println(it.values)
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun DailyDto.toDaily(): Map<Int,List<Daily>> {
    return time?.mapIndexed { index, time ->
        val weatherCode = weatherCode.get(index)
        val sunrise = sunrise?.get(index)
        val sunset= sunset?.get(index)
        val uvIndexMax = uvIndexMax.get(index)
        Daily(
            time = OffsetDateTime.parse(time),
            weatherCode = WeatherType.fromWMO(weatherCode.toInt()),
            uvIndexMax = uvIndexMax,
            sunset = OffsetDateTime.parse(time),
            sunrise = OffsetDateTime.parse(time),
        )
    }?.groupBy{
        it.time.dayOfMonth
        Log.d("","")
    } ?: emptyMap()
}