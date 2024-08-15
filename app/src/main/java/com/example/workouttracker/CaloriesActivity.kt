package com.example.workouttracker

import android.content.Intent
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class CaloriesActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    val levels: Array<String> = arrayOf("Sedentary", "Lightly Active",
        "Moderately Active", "Very Active", "Super Active")

    lateinit var radioGrp: RadioGroup       // creating radiogroup variable
    lateinit var selectedActivityLevel: String  // variable to store dropdown item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calories)

        val weightInput = findViewById<TextInputEditText>(R.id.weightInput)
        val heightInput = findViewById<TextInputEditText>(R.id.heightInput)
        val ageInput = findViewById<TextInputEditText>(R.id.ageInput)
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        radioGrp = findViewById(R.id.radioGroup)


        val dropdown = findViewById<Spinner>(R.id.activityDropdown)
        dropdown.onItemSelectedListener = this  // tells which item in list is clicked
        // array adapter adds list items to dropdown
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, levels)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dropdown.adapter = adapter

        // initialises with default selection
        selectedActivityLevel = levels[dropdown.selectedItemPosition]



        nextBtn.setOnClickListener{

            val weight = weightInput.text.toString().toInt()
            val height = heightInput.text.toString().toInt()
            val age = ageInput.text.toString().toInt()

            val selectedId = radioGrp.checkedRadioButtonId  // gets ID of selected button
            val selectedRadioButton = findViewById<RadioButton>(selectedId)
            val gender = selectedRadioButton.text.toString()

            val intent = Intent(this, CalDisplayActivity::class.java)
            intent.putExtra("Weight", weight)   // int
            intent.putExtra("Height", height)   // int
            intent.putExtra("Age", age)         // int
            intent.putExtra("Gender", gender)   // string
            intent.putExtra("ActivityLevel", selectedActivityLevel)  // string

            startActivity(intent)
        }
        }

    override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
        selectedActivityLevel = levels[position]    // updates variable
        Toast.makeText(applicationContext, selectedActivityLevel, Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        // Null
    }
}
