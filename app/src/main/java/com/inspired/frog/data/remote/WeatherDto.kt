import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Current(
    @Json(name = "time") val time: String,
    @Json(name = "interval") val interval: Int,
    @Json(name = "temperature_2m") val temperature: Double,
    @Json(name = "weathercode") val weatherCode: Int,
    @Json(name = "wind_speed_10m") val windSpeed: Double
)

@JsonClass(generateAdapter = true)
data class Hourly(
    @Json(name = "time") val time: List<String>,
    @Json(name = "temperature_2m") val temperature: List<Double>,
    @Json(name = "relative_humidity_2m") val relativeHumidity: List<Int>,
    @Json(name = "wind_speed_10m") val windSpeed: List<Double>
)

@JsonClass(generateAdapter = true)
data class CurrentUnits(
    @Json(name = "time") val time: String,
    @Json(name = "interval") val interval: String,
    @Json(name = "temperature_2m") val temperature: String,
    @Json(name = "weathercode") val weatherCode: String,
    @Json(name = "wind_speed_10m") val windSpeed: String
)

@JsonClass(generateAdapter = true)
data class HourlyUnits(
    @Json(name = "time") val time: String,
    @Json(name = "temperature_2m") val temperature: String,
    @Json(name = "relative_humidity_2m") val relativeHumidity: String,
    @Json(name = "wind_speed_10m") val windSpeed: String
)

@JsonClass(generateAdapter = true)
data class WeatherData(
    @Json(name = "latitude") val latitude: Double,
    @Json(name = "longitude") val longitude: Double,
    @Json(name = "generationtime_ms") val generationTime: Double,
    @Json(name = "utc_offset_seconds") val utcOffsetSeconds: Int,
    @Json(name = "timezone") val timezone: String,
    @Json(name = "timezone_abbreviation") val timezoneAbbreviation: String,
    @Json(name = "elevation") val elevation: Double,
    @Json(name = "current_units") val currentUnits: CurrentUnits,
    @Json(name = "current") val current: Current,
    @Json(name = "hourly_units") val hourlyUnits: HourlyUnits,
    @Json(name = "hourly") val hourly: Hourly
)