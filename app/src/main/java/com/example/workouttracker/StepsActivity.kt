package com.example.workouttracker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class StepsActivity : AppCompatActivity(), SensorEventListener {        // brings in sensor listener

    private lateinit var sensorManager: SensorManager  //initialised later (lateinit)
    private var accelerometer: Sensor? = null
    private var lastAcceleration: Float = 0f        // holds previous acceleration value
    private var currentAcceleration: Float = 0f     // holds current acceleration value
    private var acceleration: Float = 0f
    private val shakeThreshold = 11f    // shake detection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_steps)

        val stepTitle = findViewById<TextView>(R.id.stepsTitle)
        val stepsCounter = findViewById<TextView>(R.id.stepCounter)
        val backButton = findViewById<Button>(R.id.backBtn)

        sensorManager =
            getSystemService(Context.SENSOR_SERVICE) as SensorManager   // initialises sensormanager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        // initalising acceleration values
        lastAcceleration = SensorManager.GRAVITY_EARTH
        currentAcceleration = SensorManager.GRAVITY_EARTH
        acceleration = 0.00f

        backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        // allows sensor to start listening for updates
        accelerometer?.also {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onPause() {
        super.onPause()
        // when activity is paused, unregisters listener
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {     // when new sensor data is available
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) { // if event is from the accelerometer
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            val lastAcceleration = currentAcceleration
            currentAcceleration = sqrt(x * x + y * y + z * z)
            val delta = currentAcceleration - lastAcceleration      // change in acceleration
            acceleration = acceleration * 0.9f + delta

            if (acceleration > shakeThreshold) {
                onShakeDetected()
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // null
    }

    private fun onShakeDetected() {

        val stepsCounter = findViewById<TextView>(R.id.stepCounter)
        var currentSteps = stepsCounter.text.toString().toInt()
        currentSteps += 1
        stepsCounter.text = currentSteps.toString()
    }
}
