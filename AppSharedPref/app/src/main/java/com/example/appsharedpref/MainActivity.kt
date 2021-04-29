package com.example.appsharedpref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference = SharedPreference(this)
        btSave.setOnClickListener {
            val name = edText.text.toString()

            sharedPreference.save("name", name)
            Toast.makeText(this, "Usuario registrado",Toast.LENGTH_LONG).show()
        }
        btRet.setOnClickListener {

           if(sharedPreference.getValue("name")!= null) {
               textView.setText(sharedPreference.getValue("name"))
           }
        }


    }
}