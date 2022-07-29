package com.example.weather.ui.component

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.model.CityItem
import com.example.weather.data.model.Coordinate
import com.example.weather.data.model.WeatherDataItem
import com.example.weather.data.model.WeatherItem
import com.example.weather.data.networking.CoroutineDispatcherProvider
import com.example.weather.dimain.GetSchedules
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val getSchedules: GetSchedules,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
): ViewModel() {

    private val  _cityList = MutableLiveData<List<CityItem>?>().apply {
        value = null
    }

    private val  _weather = MutableLiveData<WeatherDataItem?>().apply {
        value = null
    }

    val cityList: LiveData<List<CityItem>?> = _cityList
    val weather: LiveData<WeatherDataItem?> = _weather
    var cities:List<CityItem>? = null

    private val openCityDetailsPrivate = MutableLiveData<CityItem>()
    val openRecipeDetails: LiveData<CityItem> get() = openCityDetailsPrivate

    fun getCities(){
        viewModelScope.launch(coroutineDispatcherProvider.IO()) {
            cities = getSchedules.getCities()
            _cityList.postValue(cities)
        }
    }

    fun onSearchClick(recipeName: String) {
        if(!cities.isNullOrEmpty()) {
            val searchResult = cities!!.filter { it.name.lowercase(Locale.ROOT).contains(recipeName.lowercase(Locale.ROOT)) }
            _cityList.postValue(searchResult)
        }
    }

    fun openCityDetails(city: CityItem) {
        openCityDetailsPrivate.postValue(city)
    }

    fun getWeather(coord: Coordinate){
        viewModelScope.launch(coroutineDispatcherProvider.IO()) {
            _weather.postValue(getSchedules.getWeather(coord))
        }
    }
}