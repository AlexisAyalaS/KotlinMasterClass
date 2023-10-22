package com.alexisayala.masterclass.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(@SerializedName("response") val response: String) {
}