package com.pmdm.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private var isMaleSelected:Boolean = true
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
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
    }

    private fun initListeners() {

        viewMale.setOnClickListener {
            isMaleSelected = true
            setGenderColor()
        }

        viewFemale.setOnClickListener {
            isMaleSelected = false
            setGenderColor()
        }

        rsHeight.addOnChangeListener {_,value,_ ->
            tvHeight.text = DecimalFormat("#.##").format(value) + "cm"
        }
    }

    private fun getBackgrounColor(isComponentSelected: Boolean): Int {
        val colorReference = if(isComponentSelected) {
            R.color.bg_comp_sel
        }else {
            R.color.bg_comp
        }

        return ContextCompat.getColor(this,colorReference)
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgrounColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgrounColor(!isMaleSelected))
    }

    private fun initUI() {
        setGenderColor()
    }
}