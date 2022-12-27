package com.example.googleloginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
            val enterPass = findViewById<EditText>(R.id.pass)
            val btnNext = findViewById<Button>(R.id.btnNext)
            var showMsg = ""
        btnNext.setOnClickListener {
            if (showMsg == "") {
                showMsg =enterPass.text.toString()
                Toast.makeText(this@LoginActivity, "Please enter password with minimum 8 character", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this,SuccessActivity::class.java)
                startActivity(intent)
            }
        }
        }
    }