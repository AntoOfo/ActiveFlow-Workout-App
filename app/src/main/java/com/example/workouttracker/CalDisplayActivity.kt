package com.example.workouttracker

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cal_display)

        val caloriesResult = findViewById<TextView>(R.id.caloriesResult)

        val intent = intent  // create get intent object

        val gender = intent.getStringExtra("Gender")
        val age = intent.getIntExtra("Age", 0)
        val height = intent.getIntExtra("Height", 0)
        val weight = intent.getIntExtra("Weight", 0)
        val activityLevel = intent.getStringExtra("ActivityLevel")


        }
    }
