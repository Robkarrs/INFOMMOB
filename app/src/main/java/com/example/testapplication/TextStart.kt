package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TextStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_text)

        val button1 = findViewById<Button>(R.id.button_text1_start)
        val button2 = findViewById<Button>(R.id.button_text2_start)
        val button3 = findViewById<Button>(R.id.button_text3_start)

        button1?.setOnClickListener()
        {
            val intent = Intent(this@TextStart, TextTask::class.java)

            // start the activity connect to the specified class
            startActivity(intent)
        }
        button2?.setOnClickListener()
        {
            val intent = Intent(this@TextStart, TextTask2::class.java)

            // start the activity connect to the specified class
            startActivity(intent)
        }
        button3?.setOnClickListener()
        {
            val intent = Intent(this@TextStart, TextTask3::class.java)

            // start the activity connect to the specified class
            startActivity(intent)
        }
    }
}