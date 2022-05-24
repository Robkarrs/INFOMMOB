package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        val buttonCirclesPrac = findViewById<Button>(R.id.buttonCirclesPrac)
        val buttonTextPrac = findViewById<Button>(R.id.buttonTextPrac)

        val buttonCircles = findViewById<Button>(R.id.buttonCircles)
        val buttonText = findViewById<Button>(R.id.buttonText)

        buttonCirclesPrac?.setOnClickListener()
        {
            val intent = Intent(this@MainActivity, CirclesPracticeStart::class.java)

            // start the activity connect to the specified class
            startActivity(intent)
        }
        buttonTextPrac?.setOnClickListener()
        {
            val intent = Intent(this@MainActivity, TextPracticeStart::class.java)
            startActivity(intent)
        }

        buttonCircles?.setOnClickListener()
        {
            val intent = Intent(this@MainActivity, CirclesStart::class.java)
            startActivity(intent)
        }
        buttonText?.setOnClickListener()
        {
            val intent = Intent(this@MainActivity, TextStart::class.java)//
            startActivity(intent)
        }

    }
}