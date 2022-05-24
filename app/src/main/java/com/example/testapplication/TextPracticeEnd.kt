package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TextPracticeEnd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.end_text)

        val button = findViewById<Button>(R.id.button_circles_end)

        button?.setOnClickListener()
        {
            val intent = Intent(this@TextPracticeEnd, MainActivity::class.java)

            startActivity(intent)
        }
    }
}