package com.example.weather.data.source.network
import com.example.weather.API_KEY
import com.example.weather.UNITS_KEY
import com.example.weather.data.model.CityItem
import com.example.weather.data.model.Coordinate
import com.example.weather.data.model.WeatherDataItem
import com.example.weather.data.schedule.api.Api
import com.example.weather.data.source.ScheduleEntityData
import javax.inject.Inject

class NetworkScheduleEntityData @Inject constructor(
    private val api: Api
) : ScheduleEntityData {

    override suspend fun getCities(): List<CityItem>? {
        return null
    }

    override suspend fun getWeather(coord: Coordinate): WeatherDataItem? {
        return try {
            return api.getWeather(coord.lat,coord.lon, API_KEY,UNITS_KEY)
        }catch (e:Exception){
            e.printStackTrace()
            return null
        }
    }

}