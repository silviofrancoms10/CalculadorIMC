package com.silviofranco.calculadorimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCalcular: Button
    private lateinit var inputPeso: EditText
    private lateinit var inputAltura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        buttonCalcular = findViewById(R.id.buttonCalcular)
        inputPeso = findViewById(R.id.inputPeso)
        inputAltura = findViewById(R.id.inputAltura)

        buttonCalcular.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)

            val peso = inputPeso.text.toString()
            val altura = inputAltura.text.toString()

            if (peso.isNotEmpty() && altura.isNotEmpty()){
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
            }

            startActivity(intent)
        }
    }
}