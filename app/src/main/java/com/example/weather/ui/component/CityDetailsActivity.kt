package com.example.weather.ui.component

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.weather.CITY_ITEM_KEY
import com.example.weather.R
import com.example.weather.data.model.CityItem
import com.example.weather.databinding.CityDetailsActivityBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityDetailsActivity: AppCompatActivity() {
    private lateinit var binding: CityDetailsActivityBinding
    private val viewModel: CityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CityDetailsActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val city = intent.getSerializableExtra(CITY_ITEM_KEY) as CityItem

        val map = supportFragmentManager.findFragmentById(R.id.map_fragment) as? SupportMapFragment

        map?.getMapAsync{
            val markerPos = LatLng(city.coord.lat,city.coord.lon)
            it.addMarker(MarkerOptions()
                .position(markerPos)
            )
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(markerPos,5F))
        }

        viewModel.getWeather(city.coord)

        viewModel.weather.observe(this, Observer {
            if(it!=null) {
                binding.descValue.text = it.weather.first().description
                binding.tempValue.text = "${it.main.temp} \u2103"
                binding.tempMinMaxValue.text = "${it.main.temp_min} \u2103 / ${it.main.temp_max} ℃"
                binding.airValue.text = "${it.main.humidity} \u0025"
                binding.windValue.text = "${it.wind.speed} m/s"
                binding.detailsLoading.isVisible = false
            }
        })
    }
}