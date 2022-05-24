package com.example.testapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.RelativeLayout
import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter
import kotlin.random.Random
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CirclesTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.circles_task)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels

        println(width);
        println(height);

        val buttonCircle = findViewById<Button>(R.id.button3)

        width = width - 180
        height = height - 360

        var buttonX = Random.nextInt(0, width).toFloat()
        var buttonY = Random.nextInt(0, height).toFloat()

        buttonCircle.x = buttonX;
        buttonCircle.y = buttonY;

        var lastTime = System.currentTimeMillis();
        var first = true;
        var difference = 0L;
        var circleNum = 0;
        var wrongClicks = 0;

        var rlayout = findViewById<RelativeLayout>(R.id.mainlayout);
        rlayout.setOnClickListener() {
            wrongClicks++;
            println(wrongClicks)
        }

        buttonCircle?.setOnClickListener()
        {

            //Create filename depending on time and date
            val datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d_M_y-H_m_ss"))

            var path = this.filesDir.absolutePath
            println(path)

            val fileName = "$path/circle_data_"+datetime+".txt"

            var file = File(fileName)
            file.createNewFile()

            if(first==true){
                first = false
                lastTime = System.currentTimeMillis()
            }

            difference = System.currentTimeMillis() - lastTime
            lastTime = System.currentTimeMillis()

            println(difference)

            //Saving the time
            try {
                file.appendText(difference.toString()+" ")
            }catch (e: Exception){
                e.printStackTrace()
            }

            buttonX = Random.nextInt(0, width).toFloat()
            buttonY = Random.nextInt(0, height).toFloat()
            //println(buttonX)
            //println(buttonY)
            buttonCircle.x = buttonX
            buttonCircle.y = buttonY
            circleNum++

            if(circleNum==10) {
                //Saving the amount of missed clicks
                try {
                    file.appendText(wrongClicks.toString())
                }catch (e: Exception){
                    e.printStackTrace()
                }

                val intent = Intent(this@CirclesTask, CirclesEnd::class.java)

                startActivity(intent)
            }
        }
    }
}