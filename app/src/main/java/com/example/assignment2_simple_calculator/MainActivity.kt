package com.example.assignment2_simple_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var calcButton: Button
    private lateinit var editNumber1: EditText
    private lateinit var editNumber2: EditText
    private lateinit var calcSpinner: Spinner
    private var operation = "Add"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcButton = findViewById(R.id.calculateButton)
        editNumber1 = findViewById(R.id.editNumber1)
        editNumber2 = findViewById(R.id.editNumber2)
        calcSpinner = findViewById(R.id.calcSpinner)

        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(
            this,
            R.array.calc_spinner_items,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            calcSpinner.adapter = adapter
        }

        // Set an OnItemSelectedListener for the spinner
        calcSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Get the selected item from the spinner
                val selectedItem = parent?.getItemAtPosition(position).toString()

                // Update the operation based on the selected item
                operation = selectedItem
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case where nothing is selected (if needed)
                Toast.makeText(applicationContext, "No operation selected", Toast.LENGTH_SHORT).show()
            }
        }



        calcButton.setOnClickListener {

            val num1Str = editNumber1.text.toString()
            val num2Str = editNumber2.text.toString()
            val num1 = num1Str.toDouble()
            val num2 = num2Str.toDouble()
            val result = num1 + num2

            Toast.makeText(this, "Result $operation", Toast.LENGTH_SHORT).show()
        }
    }


}