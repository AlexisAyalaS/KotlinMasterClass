package com.alexisayala.masterclass.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alexisayala.masterclass.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superHeroesItemsResponse: SuperHeroesItemsResponse) {
        binding.tvSuperHeroName.text = superHeroesItemsResponse.superHeroName
        Picasso.get().load(superHeroesItemsResponse.superHeroImage.url).into(binding.ivSuperHero)
    }
}