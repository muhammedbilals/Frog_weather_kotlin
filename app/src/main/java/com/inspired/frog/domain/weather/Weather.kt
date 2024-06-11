
data class Weather (
    val latitude: Double,
    val longitude: Double,
    val generationMs: Double,
    val utcOffsetSeconds: Long,
    val timezone: String,
    val timezoneAbbreviation: String,
    val elevation: Long,
    val currentUnits: CurrentUnits?,
    val current: Current?,
    val hourlyUnits: HourlyUnits?,
    val hourly: Hourly?
)

data class Current (
    val time: String,
    val interval: Long,
    val temperature2M: Long,
    val weathercode: Long,
    val windSpeed10M: Double
)

data class CurrentUnits (
    val time: String,
    val interval: String,
    val temperature2M: String,
    val weathercode: String,
    val windSpeed10M: String
)

data class Hourly (
    val time: List<String>,
    val temperature2M: List<Double>,
    val relativeHumidity2M: List<Long>,
    val windSpeed10M: List<Double>
)

data class HourlyUnits (
    val time: String,
    val temperature2M: String,
    val relativeHumidity2M: String,
    val windSpeed10M: String
)
