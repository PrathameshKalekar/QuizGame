package com.example.googleloginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        val SuccessView = findViewById<TextView>(R.id.Welcome)
        val getUser = intent.getStringExtra("userName")
        var message = "Wlecome you logged in successfully"
        SuccessView.text = message
    }
}