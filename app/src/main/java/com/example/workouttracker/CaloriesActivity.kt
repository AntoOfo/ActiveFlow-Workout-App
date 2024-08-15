package com.example.workouttracker

import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class CaloriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calories)

        val maleButton = findViewById<RadioButton>(R.id.maleButton)
        val femaleButton = findViewById<RadioButton>(R.id.femaleButton)
        val weightInput = findViewById<TextInputEditText>(R.id.weightInput)
        val heightInput = findViewById<TextInputEditText>(R.id.heightInput)
        val ageInput = findViewById<TextInputEditText>(R.id.ageInput)
        }
    }
