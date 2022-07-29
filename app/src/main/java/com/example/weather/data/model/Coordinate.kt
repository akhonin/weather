package com.example.weather.data.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Coordinate(
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("lat")
    val lat: Double
) : Serializable