package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TextPracticeStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_textprac)

        val button = findViewById<Button>(R.id.button_text0_start)

        button?.setOnClickListener()
        {
            val intent = Intent(this@TextPracticeStart, TextTaskprac::class.java)

            // start the activity connect to the specified class
            startActivity(intent)
        }
    }
}