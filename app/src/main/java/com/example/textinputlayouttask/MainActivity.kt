package com.example.textinputlayouttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickCountDisplayView= findViewById<TextView>(R.id.CountValue)
        val clickMeButton=findViewById<TextView>(R.id.ClickButton)
        val userNameTextInputView=findViewById<TextInputLayout>(R.id.nametext)
        val mapClickCount= mutableMapOf<String,Int>()
        clickMeButton.setOnClickListener{
            val username=userNameTextInputView.editText?.text?.toString()
            var maskedUserName=if (username.isNullOrEmpty()) "somebody"
            else username
             val oldClickCount=mapClickCount[maskedUserName]?:0
            val newClickCount=oldClickCount+1
            mapClickCount[maskedUserName]=newClickCount
            clickCountDisplayView.text="$maskedUserName Clicked $newClickCount times"
        }
    }
}