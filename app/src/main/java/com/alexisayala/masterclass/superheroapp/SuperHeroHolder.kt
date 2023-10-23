package com.alexisayala.masterclass.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alexisayala.masterclass.databinding.ItemSuperheroBinding

class SuperHeroHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superHeroesItemsResponse: SuperHeroesItemsResponse) {
        binding.tvSuperHeroName.text = superHeroesItemsResponse.superHeroName
    }
}