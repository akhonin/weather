package com.example.weather.ui.component

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.CITY_ITEM_KEY
import com.example.weather.R
import com.example.weather.data.model.CityItem
import com.example.weather.databinding.CityListActivityBinding
import com.example.weather.ui.component.adapter.CityAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CityListActivity: AppCompatActivity() {
    private lateinit var binding: CityListActivityBinding
    private val viewModel: CityViewModel by viewModels()
    private lateinit var recipesAdapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CityListActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)

        binding.rvCityList.layoutManager = layoutManager
        binding.rvCityList.setHasFixedSize(true)

        viewModel.getCities()

        showLoadingView()

        viewModel.cityList.observe(this, Observer {
            bindListData(it)
        })

        viewModel.openRecipeDetails.observe(this, Observer {
            it?.let {
                val nextScreenIntent = Intent(this, CityDetailsActivity::class.java).apply {
                    putExtra(CITY_ITEM_KEY, it)
                }
                startActivity(nextScreenIntent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_actions, menu)
        val searchView = menu?.findItem(R.id.action_search)?.actionView as SearchView
        searchView.queryHint = getString(R.string.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                handleSearch(newText)
                return false
            }
        })
        return true
    }

    private fun handleSearch(query: String) {
        if (query.isNotEmpty()) {
            binding.pbLoading.visibility = View.VISIBLE
            viewModel.onSearchClick(query)
        }else{
            showLoadingView()
            viewModel.getCities()
        }
    }

    private fun bindListData(cities: List<CityItem>?) {
        if(cities!=null) {
            recipesAdapter = CityAdapter(viewModel, cities, baseContext)
            binding.rvCityList.adapter = recipesAdapter
            showDataView()
            binding.noData.isVisible = cities.isEmpty()
        }
    }

    private fun showLoadingView() {
        binding.pbLoading.isVisible = true
        binding.rvCityList.isVisible = false
        binding.noData.isVisible = false
    }

    private fun showDataView() {
        binding.pbLoading.isVisible = false
        binding.rvCityList.isVisible = true
    }


}