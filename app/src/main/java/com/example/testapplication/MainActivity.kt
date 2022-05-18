package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        val button = findViewById<Button>(R.id.button)

        button?.setOnClickListener()
        {
            val intent = Intent(this@MainActivity, CirclesStart::class.java)

            // start the activity connect to the specified class

            // start the activity connect to the specified class
            startActivity(intent)
        }

    }


}