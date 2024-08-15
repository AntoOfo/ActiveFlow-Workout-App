package com.example.workouttracker

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calories)

        val maleButton = findViewById<RadioButton>(R.id.maleButton)
        val femaleButton = findViewById<RadioButton>(R.id.femaleButton)
        val weightInput = findViewById<TextInputEditText>(R.id.weightInput)
        val heightInput = findViewById<TextInputEditText>(R.id.heightInput)
        val ageInput = findViewById<TextInputEditText>(R.id.ageInput)


        val dropdown = findViewById<Spinner>(R.id.activityDropdown)
        dropdown.onItemSelectedListener = this  // tells which item in list is clicked

        // array adapter adds list items to dropdown
        val add: ArrayAdapter<*> = ArrayAdapter<Any?>(this,
                                        android.R.layout.simple_spinner_item, levels)

        dropdown.adapter = add      // binds data to dropdown

        }

    override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {

        Toast.makeText(applicationContext, levels[position], Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        // Null
    }
}
