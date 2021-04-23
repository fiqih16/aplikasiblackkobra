package com.example.blackcobra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class showdataregister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showdataregister)

        supportActionBar!!.setTitle("Show Data")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //get data from intent
        val intent = intent
        val fname       = intent.getStringExtra("F_Name")
        val lname       = intent.getStringExtra("L_Name")
        val email       = intent.getStringExtra("Email")
        val password    = intent.getStringExtra("Password")
        val rpassword   = intent.getStringExtra("R_Password")
        //textview
        val result = findViewById<TextView>(R.id.resultRegister)
        //setText
        result.text = "Name:\n\t\t\b"+fname+ " " +lname+
                "\n\nEmail:\n\t\t\b"+email+
                "\n\nPassword:\n\t\t\b"+password
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }
}