package com.alexisayala.masterclass.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexisayala.masterclass.R

class SuperHeroAdapter(var superHeroList: List<SuperHeroesItemsResponse> = emptyList()): RecyclerView.Adapter<SuperHeroHolder>() {
    fun updateList(superHeroList: List<SuperHeroesItemsResponse>){
        this.superHeroList= superHeroList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroHolder {
        return SuperHeroHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false))
    }

    override fun getItemCount() = superHeroList.size

    override fun onBindViewHolder(viewHolder: SuperHeroHolder, position: Int) {
        viewHolder.bind(superHeroList[position])
    }

}