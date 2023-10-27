package com.alexisayala.masterclass.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexisayala.masterclass.databinding.ActivityDetailSuperHeroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperHeroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSuperHeroBinding
    private lateinit var retrofit: Retrofit

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperHeroInformation(id)
    }

    private fun getSuperHeroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superherodetail =
                getRetrofit().create(ApiService::class.java).getSuperHeroDetail(id)
            if (superherodetail.body() != null) {
                runOnUiThread {
                    createUI(superherodetail.body()!!)
                }

            }
        }
    }

    private fun createUI(superhero: SuperheroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperHero)

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}