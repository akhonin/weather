package com.example.weather.dimain

import com.example.weather.data.model.CityItem
import com.example.weather.data.model.Coordinate
import com.example.weather.data.model.WeatherDataItem
import javax.inject.Inject

class GetSchedules @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) {

    suspend fun getCities(): List<CityItem>?{
        return scheduleRepository.getCities()
    }

    suspend fun getWeather(coord: Coordinate): WeatherDataItem?{
        return scheduleRepository.getWeather(coord)
    }

}