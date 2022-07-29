package com.example.weather.data.source.local

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.weather.App
import com.example.weather.data.model.CityItem
import com.example.weather.data.model.Coordinate
import com.example.weather.data.model.WeatherDataItem
import com.example.weather.data.source.ScheduleEntityData
import java.io.InputStream
import javax.inject.Inject

class LocalScheduleEntityData @Inject constructor(
) : ScheduleEntityData {

    override suspend fun getCities(): List<CityItem>? {

        return try {
            val inputStream: InputStream = App.instans!!.assets.open("city_list.json")
            val json = inputStream.bufferedReader().use { it.readText() }
            val typeToken = object : TypeToken<List<CityItem>>() {}.type
            Gson().fromJson<List<CityItem>>(json, typeToken)
        }catch (e:Exception){
            e.printStackTrace()
            null
        }
    }

    override suspend fun getWeather(coord: Coordinate): WeatherDataItem? {
        return null
    }
}