import com.plcoding.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime


data class Weather (
    val latitude: Double,
    val longitude: Double,
    val current: Current,
    val hourly: Map<Int,List<Hourly>>,
//    val daily: Map<Int,List<Daily>>
)

data class Current (
    val time: LocalDateTime,
    val temperature2M: Double,
    val relativeHumidity2M: Double,
    val apparentTemperature: Double,
    val isDay: Boolean,
    val precipitation: Double,
    val weatherCode: WeatherType,
    val windSpeed10M: Double
)


data class Daily (
    val time: LocalDateTime,
    val weatherCode: WeatherType,
    val sunrise: LocalDateTime,
    val sunset: LocalDateTime,
    val uvIndexMax: Double
)

data class Hourly (
    val time: LocalDateTime,
    val temperature2M: Double,
    val weatherCode: WeatherType
)
