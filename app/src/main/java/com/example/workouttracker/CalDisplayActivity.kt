package com.example.workouttracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.round

class CalDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cal_display)

        val caloriesResult = findViewById<TextView>(R.id.caloriesResult)
        val backBtn = findViewById<Button>(R.id.calbackBtn)


        val intent = intent  // create get intent object

        val gender = intent.getStringExtra("Gender")
        val age = intent.getIntExtra("Age", 0)
        val height = intent.getIntExtra("Height", 0)
        val weight = intent.getIntExtra("Weight", 0)
        val activityLevel = intent.getStringExtra("ActivityLevel")

        var bmr = 0    // basal metabolic rate
        var doubleBmr = bmr.toDouble()
        var tdee = 0
        var doubleTdee = tdee.toDouble()

        val activityRates = when (activityLevel) {
            "Sedentary" -> 1.2
            "Lightly Active" -> 1.375
            "Moderately Active" -> 1.55
            "Very Active" -> 1.725
            "Super Active" -> 1.9
            else -> 1.2
        }


        if (gender == "Male") {
                doubleBmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)
                doubleTdee = doubleBmr * activityRates
                val roundedTdee = doubleTdee.toInt()

                caloriesResult.text = roundedTdee.toString()
            }
        else if (gender == "Female") {
            doubleBmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age)
            doubleTdee = doubleBmr * activityRates
            val roundedTdee = doubleTdee.toInt()

            caloriesResult.text = roundedTdee.toString()
        }

        backBtn.setOnClickListener{
            val intent = Intent(this, CaloriesActivity::class.java)
            startActivity(intent)
        }

        }


        }

