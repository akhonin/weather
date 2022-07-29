package com.example.weather.data.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CityItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("coord")
    val coord: Coordinate,
) : Serializable