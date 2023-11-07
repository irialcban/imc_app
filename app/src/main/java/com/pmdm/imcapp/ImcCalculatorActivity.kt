package com.pmdm.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    var isMaleSelected:Boolean = true
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
    }

    private fun initListeners() {

        viewMale.setOnClickListener {
            setGenderColor()
        }

        viewFemale.setOnClickListener {
            setGenderColor()
        }
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgrounColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgrounColor(!isMaleSelected))
    }

    private fun getBackgrounColor(isComponentSelected: Boolean): Int {
        val colorReference = if(isComponentSelected) {
            R.color.bg_comp_sel
        }else {
            R.color.bg_comp
        }

        return ContextCompat.getColor(this,colorReference)
    }

    private fun initUI() {
        setGenderColor()
    }
}