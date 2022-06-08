package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


public var datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d_M_y-H_m_ss"))
public var circlesTime = 0;
//public var file = File.createNewFile();

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Create filename depending on time and date
        //datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d_M_y-H_m_ss"))

        //file = File(getExternalFilesDir("MyFileStorage"), datetime.toString())

        val buttonCirclesPrac = findViewById<Button>(R.id.buttonCirclesPrac)
        val buttonTextPrac = findViewById<Button>(R.id.buttonTextPrac)

        val buttonCircles = findViewById<Button>(R.id.buttonCircles)
        val buttonText = findViewById<Button>(R.id.buttonText)


        buttonCircles?.setOnClickListener()
        {
            val intent = Intent(this@MainActivity, CirclesStart::class.java)
            startActivity(intent)
        }
        buttonText?.setOnClickListener()
        {
            val intent = Intent(this@MainActivity, TextStart::class.java)
            startActivity(intent)
        }

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

    }
}