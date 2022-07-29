package com.example.weather.data.schedule.api

import com.example.weather.data.model.WeatherDataItem
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.*

interface Api {

    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat: Double?,
        @Query("lon") lon: Double?,
        @Query("appid") appid: String?,
        @Query("units") units: String?,
    ): WeatherDataItem
}