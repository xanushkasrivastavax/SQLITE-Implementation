package com.example.loginapp_sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var handler: DBHelper
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val inputEmail=findViewById<EditText>(R.id.inputEmailLogin)
        val inputPassword=findViewById<EditText>(R.id.inputPasswordLogin)
        val loginBtn=findViewById<Button>(R.id.btn_signin)

        loginBtn.setOnClickListener {
            handler= DBHelper(this)
            val name = inputEmail.getText().toString()
            val password = inputPassword.getText().toString()

            if (name == "" || password == "")
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show()
            else {
                if(handler.userPresent(name,password)) {
                    Toast.makeText(this, "Sign in successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}