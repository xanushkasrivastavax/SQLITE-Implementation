package com.example.loginapp_sqlite

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var handler: DBHelper
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.login)
        val login=findViewById<TextView>(R.id.textView4)
        login.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        btn.setOnClickListener{
            handler= DBHelper(this)
            val inputName = findViewById<EditText>(R.id.inputName)
            val name=    inputName.getText().toString()
            val inputEmail = findViewById<EditText>(R.id.inputEmail)
            val email= inputEmail.getText().toString()
            val inputPassword = findViewById<EditText>(R.id.inputPassword)
            val password= inputPassword.getText().toString()
            handler.insertUserData(name,email,password)
            Toast.makeText(this, "$name added to database", Toast.LENGTH_LONG).show()
            inputName.getText().clear()
            inputEmail.getText().clear()
            inputPassword.getText().clear()

        }

    }
}