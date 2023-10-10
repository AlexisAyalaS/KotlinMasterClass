package com.alexisayala.masterclass.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.alexisayala.masterclass.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvew = findViewById<TextView>(R.id.textViewElement)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvew.text = "Hola $name"
    }
}