package com.example.weather.data.source

import com.example.weather.data.model.CityItem
import com.example.weather.data.model.Coordinate
import com.example.weather.data.model.WeatherDataItem


interface ScheduleEntityData {
    suspend fun getCities(): List<CityItem>?

    suspend fun getWeather(coord: Coordinate): WeatherDataItem?
}