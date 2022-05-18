package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CirclesEnd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.end_circles)

        val button = findViewById<Button>(R.id.button_circles_end)

        button?.setOnClickListener()
        {
            val intent = Intent(this@CirclesEnd, MainActivity::class.java)

            startActivity(intent)
        }
    }
}