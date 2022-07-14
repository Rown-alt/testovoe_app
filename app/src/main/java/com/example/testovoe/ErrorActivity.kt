package com.example.testovoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        val button : Button = findViewById(R.id.error_btn)

        button.setOnClickListener {
            val intent = Intent(this@ErrorActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}