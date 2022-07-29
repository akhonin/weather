package com.example.weather.ui.component.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weather.data.model.CityItem
import com.example.weather.databinding.CityItemBinding
import com.example.weather.ui.listeners.CityItemListener

class CityViewHolder(private val itemBinding: CityItemBinding,
                     private val context:Context,
                     private val pos: Int
                     ) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(recipesItem: CityItem, recyclerItemListener: CityItemListener) {
        itemBinding.city.text = recipesItem.name
        itemBinding.country.text = recipesItem.country

        if (pos % 2 == 0) {
            Glide.with(context)
                .load("https://infotech.gov.ua/storage/img/Temp3.png")
                .into(itemBinding.image)
        }else{
            Glide.with(context)
                .load("https://infotech.gov.ua/storage/img/Temp1.png")
                .into(itemBinding.image)
        }
        itemBinding.rlRecipeItem.setOnClickListener { recyclerItemListener.onItemSelected(recipesItem) }
    }
}