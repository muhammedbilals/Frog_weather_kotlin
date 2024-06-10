data class WeatherInfo(
    val latitude: Double,
    val longitude: Double,
    val generationTime: Double,
    val utcOffsetSeconds: Int,
    val timezone: String,
    val timezoneAbbreviation: String,
    val elevation: Double,
    val current: CurrentDomainModel,
    val hourly: HourlyDomainModel
)

data class CurrentDomainModel(
    val time: String,
    val interval: Int,
    val temperature: Double,
    val weatherCode: Int,
    val windSpeed: Double
)

data class HourlyDomainModel(
    val time: List<String>,
    val temperature: List<Double>,
    val relativeHumidity: List<Int>,
    val windSpeed: List<Double>
)
