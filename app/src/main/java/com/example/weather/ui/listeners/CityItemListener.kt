package com.example.weather.ui.listeners

import com.example.weather.data.model.CityItem


interface CityItemListener {
    fun onItemSelected(recipe : CityItem)
}