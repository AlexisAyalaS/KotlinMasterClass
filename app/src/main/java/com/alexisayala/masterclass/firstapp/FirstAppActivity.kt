package com.alexisayala.masterclass.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.alexisayala.masterclass.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        //on launch

        val btnClick = findViewById<AppCompatButton>(R.id.btnClick)
        val editTextClick = findViewById<AppCompatEditText>(R.id.ediInput)


        btnClick.setOnClickListener {
            val name = editTextClick.text.toString()

            if (name.isNotEmpty()) {
                Log.i("Alexis", name)
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }

        }
    }
}