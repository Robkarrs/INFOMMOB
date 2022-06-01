package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.File

val textList = arrayOf("This is the first test message","This is the second test message")
var count = 0
var backspaceCount = 0
class TextTask  : AppCompatActivity(){
    private val filepath = "MyFileStorage"
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_task)
        val displayText = findViewById<TextView>(R.id.textDisplay)
        displayText.text = textList[count]

       val buttonText = findViewById<Button>(R.id.button)
       buttonText?.setOnClickListener()
       {
           storeMessage()
       }
    }

    fun countBackspace()
    {

    }
    fun storeMessage() {
        //Show next line
        count++
        val displayText = findViewById<TextView>(R.id.textDisplay)
        displayText.text = textList[count]

        //collect entered text
        val editText = findViewById<EditText>(R.id.textinput)
        val message = editText.text.toString()
        editText.text.clear()

        //Compare message and displayed text

        //Adjust scoring
        //Compare string differences
        //Store File
        val file = File(getExternalFilesDir(filepath), datetime.toString())
        //val path = Environment.getExternalStorageDirectory()
        println(getExternalFilesDir(filepath))
        file.createNewFile()
        try {
            file.appendText(message + " ")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}