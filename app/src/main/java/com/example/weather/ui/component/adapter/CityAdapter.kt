package com.example.weather.ui.component.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.data.model.CityItem
import com.example.weather.databinding.CityItemBinding
import com.example.weather.ui.component.CityViewModel
import com.example.weather.ui.listeners.CityItemListener

class CityAdapter(private val viewModel: CityViewModel,
                  private val recipes: List<CityItem>,
                  private val context: Context
)
    : RecyclerView.Adapter<CityViewHolder>() {

    private val onItemClickListener: CityItemListener = object : CityItemListener {
        override fun onItemSelected(recipe: CityItem) {
            viewModel.openCityDetails(recipe)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val itemBinding = CityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(itemBinding,context,viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(recipes[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}