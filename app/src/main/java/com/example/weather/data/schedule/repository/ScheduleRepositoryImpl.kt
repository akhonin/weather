package com.example.weather.data.schedule.repository

import com.example.weather.data.model.CityItem
import com.example.weather.data.model.Coordinate
import com.example.weather.data.model.WeatherDataItem
import com.example.weather.data.schedule.factory.ScheduleFactory
import com.example.weather.dimain.ScheduleRepository
import com.example.weather.util.Source
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleFactory: ScheduleFactory
) : ScheduleRepository {

    override suspend fun getCities(): List<CityItem>? {
        return scheduleFactory.create(Source.LOCAL).getCities()
    }

    override suspend fun getWeather(coord: Coordinate): WeatherDataItem? {
        return scheduleFactory.create(Source.NETWORK).getWeather(coord)
    }
}