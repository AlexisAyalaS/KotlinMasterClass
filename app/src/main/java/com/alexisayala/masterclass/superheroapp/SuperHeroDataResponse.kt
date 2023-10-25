package com.alexisayala.masterclass.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superHeroes: List<SuperHeroesItemsResponse>
) {
}

data class SuperHeroesItemsResponse(
    @SerializedName("id") val superHeroId: String,
    @SerializedName("name") val superHeroName: String,
    @SerializedName("image") val superHeroImage: SuperHeroImageResponse
)

data class SuperHeroImageResponse(
    @SerializedName("url") val url: String,
)