package com.example.loginapp_sqlite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.addUser)
        btn.setOnClickListener{
            val db = DBHelper(this, null)
            val name1 = findViewById<EditText>(R.id.inputName)
            val name=    name1.getText().toString()
            val email1 = findViewById<EditText>(R.id.inputEmail)
            val email= email1.getText().toString()
            val password1 = findViewById<EditText>(R.id.inputPassword)
            val password= password1.getText().toString()
            db.addUser(name,email, password)
            Toast.makeText(this, "$name added to database", Toast.LENGTH_LONG).show()
            name1.getText().clear()
            email1.getText().clear()
            password1.getText().clear()

        }

    }
}