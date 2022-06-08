package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CirclesStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_circles)

        val button = findViewById<Button>(R.id.button_text0_start)

        button?.setOnClickListener()
        {
            val intent = Intent(this@CirclesStart, CirclesTask::class.java)

            // start the activity connect to the specified class
            startActivity(intent)
        }
    }
}