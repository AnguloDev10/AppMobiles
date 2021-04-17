package com.example.ejm01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class DisplayMessageAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val message = intent.getStringExtra(EXTRA_MESS)

        val textView = findViewById<TextView>(R.id.tvMessagge).apply {
            text = message
        }
    }
}