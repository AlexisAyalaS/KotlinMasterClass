package com.alexisayala.masterclass.imccalculator

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.alexisayala.masterclass.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private var currentHeight: Int = 120
    private lateinit var textHeight: TextView
    private lateinit var rangeHeight: RangeSlider

    private var currentWeight: Int = 60
    private lateinit var textWeight: TextView
    private lateinit var substractWeight: FloatingActionButton
    private lateinit var addWeight: FloatingActionButton

    private var currentAge: Int = 20
    private lateinit var textAge: TextView
    private lateinit var substractAge: FloatingActionButton
    private lateinit var addAge: FloatingActionButton

    private lateinit var calculate: Button

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        textHeight = findViewById(R.id.textHeight)
        rangeHeight = findViewById(R.id.rangeHeight)
        textWeight = findViewById(R.id.textWeight)
        substractWeight = findViewById(R.id.subtractWeight)
        addWeight = findViewById(R.id.addWeight)
        textAge = findViewById(R.id.textAge)
        substractAge = findViewById(R.id.subtractAge)
        addAge = findViewById(R.id.addAge)
        calculate = findViewById(R.id.calculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rangeHeight.addOnChangeListener { _, value, _ ->
            val decimalFormat = DecimalFormat("#.##")
            currentHeight = decimalFormat.format(value).toInt()
            setHeight()
//            textHeight.text = "$currentHeight cm"
//            currentHeight = currentHeight.toInt()
        }
        substractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        addWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        substractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        addAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        calculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
        setHeight()
    }

    private fun setHeight() {
        textHeight.text = "$currentHeight cm"
    }

    private fun setWeight() {
        textWeight.text = "$currentWeight kg"
    }

    private fun setAge() {
        textAge.text = currentAge.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        var imc = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)
        return df.format(imc).toDouble()
    }

    private fun navigateToResult(result: Double) {
        var intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }
}