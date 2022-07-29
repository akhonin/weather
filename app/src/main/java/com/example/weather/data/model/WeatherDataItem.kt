package com.example.weather.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherDataItem (
    @SerializedName("coord")
    val coord: Coordinate,
    @SerializedName("weather")
    val weather: List<WeatherItem>,
    @SerializedName("base")
    val base: String,
    @SerializedName("main")
    val main: WeatherMainItem,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("wind")
    val wind: WeatherWindItem,
    @SerializedName("clouds")
    val clouds: WeatherCloudItem,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("sys")
    val sys: WeatherSysItem,
    @SerializedName("timezone")
    val timezone: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("cod")
    val cod: Int,
) : Serializable