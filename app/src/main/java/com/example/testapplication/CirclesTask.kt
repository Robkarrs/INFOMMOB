package com.example.testapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
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
    private val filepath = "MyFileStorage"

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
        val stepWNum = 5
        val stepHNum = 10
        val widthPad = 50
        val heightPad = 80
        val totalSteps = stepWNum * stepHNum
        val stepWSize = width/stepWNum
        val stepHSize = height/stepHNum
        var allSteps = Array(50,{i->i*1})
        allSteps.shuffle()
        println(allSteps)

        println("stepWSize "+stepWSize)
        println("stepHSize "+stepHSize)

        /*var arrayCompleted = false

        while(arrayCompleted == false){
            random
            allSteps[0] = 0
        }*/



        val totalCircles = 60

        var ind = 0

        println("Index "+allSteps[ind])

        var temp = allSteps[ind]/10
        println("Temp "+temp)
        var buttonX = (temp*stepWSize).toFloat()
        var buttonY = ((allSteps[ind]-10*temp)*stepHSize).toFloat()


        buttonCircle.x = widthPad+buttonX
        buttonCircle.y = heightPad+buttonY

        var lastTime = System.currentTimeMillis();
        var first = true;
        var difference = 0L;
        var differenceAvg = 0L;
        var circleNum = 0;
        var wrongClicks = 0;
        var timeValues = ""

        //Create filename depending on time and date
        //val datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d_M_y-H_m_ss"))

        //var path = this.filesDir.absolutePath
        //println(path)

        val file = File(getExternalFilesDir(filepath), datetime.toString())
        //val path = Environment.getExternalStorageDirectory()
        println(getExternalFilesDir(filepath))
        file.createNewFile()

        var rlayout = findViewById<RelativeLayout>(R.id.mainlayout);
        rlayout.setOnClickListener() {
            wrongClicks++;
            println(wrongClicks)
        }

        buttonCircle?.setOnClickListener()
        {

            circleNum++

            if(first==true){
                lastTime = System.currentTimeMillis()
            }

            difference = System.currentTimeMillis() - lastTime
            lastTime = System.currentTimeMillis()

            println(difference)

            //Saving the time
            if(first!=true) {
                differenceAvg = differenceAvg + difference;

                if(circleNum!=totalCircles)
                    timeValues = timeValues.plus(difference.toString() + ",")
                else
                    timeValues = timeValues.plus(difference.toString())

                /*try {
                    file.appendText(difference.toString() + " ")
                } catch (e: Exception) {
                    e.printStackTrace()
                }*/
            }
            else{
                first=false;
            }

            //buttonX = Random.nextInt(0, width).toFloat()
            //buttonY = Random.nextInt(0, height).toFloat()

            var ind = circleNum%50

            println("Index "+allSteps[ind])

            var temp = allSteps[ind]/10
            println("Temp "+temp)
            buttonX = (temp*stepWSize).toFloat()
            buttonY = ((allSteps[ind]-10*temp)*stepHSize).toFloat()


            println("X "+buttonX)
            println("Y "+buttonY)
            buttonCircle.x = widthPad+buttonX
            buttonCircle.y = heightPad+buttonY

            if(circleNum==totalCircles) {
                differenceAvg = differenceAvg/(circleNum-1)
                circleNum=0

                //Saving the time scores
                try {
                    file.appendText(timeValues.toString() + " ")
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                //Saving the average time
                try {
                    file.appendText(differenceAvg.toString() + " ")
                } catch (e: Exception) {
                    e.printStackTrace()
                }


                //Saving the amount of missed clicks
                try {
                    file.appendText(wrongClicks.toString() + " ")
                }catch (e: Exception){
                    e.printStackTrace()
                }

                val intent = Intent(this@CirclesTask, CirclesEnd::class.java)

                startActivity(intent)
            }
        }
    }
}