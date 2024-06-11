package com.inspired.frog.di


import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.inspired.frog.data.remote.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit
            .Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build().create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun ProviceFusedLocationProviderClient(app : Application):FusedLocationProviderClient{
        return LocationServices.getFusedLocationProviderClient(app)
    }
}