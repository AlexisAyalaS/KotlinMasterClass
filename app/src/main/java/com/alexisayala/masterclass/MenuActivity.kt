package com.alexisayala.masterclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.alexisayala.masterclass.firstapp.FirstAppActivity
import com.alexisayala.masterclass.firstapp.ResultActivity
import com.alexisayala.masterclass.imccalculator.ImcCalculatorActivity
import com.alexisayala.masterclass.superheroapp.SuperHeroListActivity
import com.alexisayala.masterclass.todo.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnGreet = findViewById<Button>(R.id.btnsaludapp)
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnSuperHero = findViewById<Button>(R.id.btnSuperHero)
        btnGreet.setOnClickListener {
            navigateToGreetingApp()
        }
        btnIMC.setOnClickListener {
            navigateToIMC()
        }
        btnTODO.setOnClickListener {
            navigateToTODO()
        }
        btnSuperHero.setOnClickListener {
            navigateToSuperHero()
        }
    }

    private fun navigateToGreetingApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMC() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTODO() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSuperHero() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }
}