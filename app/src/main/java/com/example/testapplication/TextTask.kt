package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

val textList = arrayOf("This is the first test message","This is the second test message")
var count = 0
class TextTask  : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_task)
        val displayText = findViewById<TextView>(R.id.textDisplay)
        displayText.text = textList[count]
    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
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

    }

}