import com.plcoding.weatherapp.domain.weather.WeatherType
import java.time.ZonedDateTime


data class Weather (
    val latitude: Double,
    val longitude: Double,
    val current: Current,
    val hourly: Map<Int,List<Hourly>>,
    val daily: Map<Int,List<Daily>>
)

data class Current (
    val time: ZonedDateTime,
    val temperature2M: Double,
    val relativeHumidity2M: Double,
    val apparentTemperature: Double,
    val isDay: Boolean,
    val precipitation: Double,
    val weatherCode: WeatherType,
    val windSpeed10M: Double
)


data class Daily (
    val time: ZonedDateTime,
    val weatherCode: WeatherType,
    val sunrise: ZonedDateTime,
    val sunset: ZonedDateTime,
    val uvIndexMax: Double
)

data class Hourly (
    val time: ZonedDateTime,
    val temperature2M: Double,
    val weatherCode: WeatherType
)
