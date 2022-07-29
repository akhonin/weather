package com.example.weather.data.model

import com.google.gson.annotations.SerializedName

data class WeatherCloudItem(
    @SerializedName("all")
    val all: Int
)