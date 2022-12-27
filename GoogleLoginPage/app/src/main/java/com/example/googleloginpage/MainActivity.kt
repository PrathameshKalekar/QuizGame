package com.example.googleloginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

//            val View = findViewById<TextView>(R.id.Google)
//            val emailEnter =findViewById<EditText>(R.id.enterEmail)
            val NextBtn = findViewById<Button>(R.id.btnNext)
            val EnterName = findViewById<EditText>(R.id.enterName)
            var EnteredName = ""
            NextBtn.setOnClickListener {
                EnteredName = EnterName.text.toString()
                if(EnteredName == "") {
                    Toast.makeText(this@MainActivity,"Please enter your name",Toast.LENGTH_SHORT).show()
                }
                else{
                    var intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                }

            }

    }
}