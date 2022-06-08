package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File



class TextTaskprac  : AppCompatActivity(){
    private val filepath = "MyFileStorage"
    val textList = arrayOf(
        "healthy food is good for you",
        "hands on experience with a job",
        "earthquakes are predictable",)

    var count = 0
    var backspaceCount = 0

    var textScore = arrayOfNulls<Int?> (textList.size)
    var errorScore = arrayOfNulls<Int?> (textList.size)
    var startTime = 0L
    var oldText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_taskprac)
        val displayText = findViewById<TextView>(R.id.textDisplay)
        displayText.text = textList[count]
        startTime = System.currentTimeMillis()
        val buttonText = findViewById<Button>(R.id.button)
        buttonText?.setOnClickListener()
        {
            storeMessage()
        }

        val enterText = findViewById<TextView>(R.id.textinput)
        enterText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (s.length < oldText.length)
                {
                    backspaceCount++
                }
                oldText = s.toString()
            }
        })
    }


    private fun storeMessage() {
        //collect entered text
        val editText = findViewById<EditText>(R.id.textinput)
        val message = editText.text.toString()
        editText.text.clear()

        //Compare message and displayed text
        stringCount(message)
        errorScore[count] = backspaceCount
        backspaceCount = 0

        //Show next line
        count++
        if (count < textList.size)
        {
            val displayText = findViewById<TextView>(R.id.textDisplay)
            displayText.text = textList[count]
        }
        else
        {
            //Exit game
            val intent = Intent(this@TextTaskprac, TextEnd::class.java)
            // start the activity connect to the specified class
            startActivity(intent)
        }


    }

    private fun stringCount(str: String)
    {
        textScore[count] = str.compareTo(textList[count])
        //println(textScore[count])
    }

}