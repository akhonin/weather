package com.example.weather.dimain

import com.example.weather.data.model.CityItem
import com.example.weather.data.model.Coordinate
import com.example.weather.data.model.WeatherDataItem

interface ScheduleRepository {
    suspend fun getCities(): List<CityItem>?

    suspend fun getWeather(coord: Coordinate): WeatherDataItem?
}