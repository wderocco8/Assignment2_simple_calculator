package com.example.assignment2_simple_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var calcButton: Button
    private lateinit var editNumber1: EditText
    private lateinit var editNumber2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcButton = findViewById(R.id.calculateButton)
        editNumber1 = findViewById(R.id.editNumber1)
        editNumber2 = findViewById(R.id.editNumber2)


        calcButton.setOnClickListener {

            val num1Str = editNumber1.text.toString()
            val num2Str = editNumber2.text.toString()
            val num1 = num1Str.toDouble()
            val num2 = num2Str.toDouble()
            val result = num1 + num2

            Toast.makeText(this, "Result $result", Toast.LENGTH_SHORT).show()
        }
    }


}