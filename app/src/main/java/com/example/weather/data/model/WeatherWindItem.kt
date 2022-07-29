package com.example.weather.data.model

import com.google.gson.annotations.SerializedName

data class WeatherWindItem(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val deg: Double
)