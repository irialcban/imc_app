package com.pmdm.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.pmdm.imcapp.ImcCalculatorActivity.Companion.IMC_KEY

class ImcResultActivity : AppCompatActivity() {
    private lateinit var tvTextResult:TextView
    private lateinit var tvResult:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnReCalculate:AppCompatButton
    private val imc = intent.extras?.getDouble(IMC_KEY)?:-1.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        tvTextResult = findViewById(R.id.tvTextResult)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener {
            val intentICA = Intent(this,ImcCalculatorActivity::class.java)
            startActivity(intentICA)
        }
    }

    private fun setResult() {
        tvResult.text = imc.toString()
    }

    private fun setDescription() {
        when(imc) {
            in 0.0 .. 18.5 -> tvDescription.text = getString(R.id.lower)
        }
    }

    private fun initUI() {
        setResult()
    }
}