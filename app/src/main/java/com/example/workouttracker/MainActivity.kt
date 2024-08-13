package com.example.workouttracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val stepsButton = findViewById<Button>(R.id.stepsBtn)
        val heartButton = findViewById<Button>(R.id.heartBtn)
        val caloriesButton = findViewById<Button>(R.id.caloriesBtn)

        stepsButton.setOnClickListener{
            val intent = Intent(this, StepsActivity::class.java)
            startActivity(intent)
        }
        }
    }
