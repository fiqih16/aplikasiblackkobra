package com.example.blackcobra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.setTitle("Register Now")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val etFirstName      = findViewById<EditText>(R.id.first_name)
        val etLastName       = findViewById<EditText>(R.id.last_name)
        val etEmail          = findViewById<EditText>(R.id.email)
        val etPassword       = findViewById<EditText>(R.id.password)
        val etRepeatPassword = findViewById<EditText>(R.id.repeat_password)
        val btnRegister      = findViewById<Button>(R.id.btn_register)

        //handle button click
        btnRegister.setOnClickListener {
            if(etFirstName.text.toString() == ""){
                Toast.makeText(this, "First name tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                etFirstName.setSelection(0)
                true
            }
            else if(etLastName.text.toString() == ""){
                Toast.makeText(this, "Last name tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                true
            }
            else if(etEmail.text.toString() == ""){
                Toast.makeText(this, "Email tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                true
            }
            else if(etPassword.text.toString() == ""){
                Toast.makeText(this, "Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                true
            }
            else if(etRepeatPassword.text.toString() == ""){
                Toast.makeText(this, "Repeat Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                true
            }
            else if(etPassword.text.toString() != etRepeatPassword.text.toString()){
                Toast.makeText(this, "Repeat Password harus sama dengan password!", Toast.LENGTH_SHORT).show()
                true
            }
            else{
                //get text from edittexts
                val get_f_name          = etFirstName.text.toString()
                val get_l_name          = etLastName.text.toString()
                val getemail            = etEmail.text.toString()
                val getPassword         = etPassword.text.toString()
                val getRepeatPassword   = etRepeatPassword.text.toString()

                //intent to start activity
                val intent = Intent(applicationContext, showdataregister::class.java)
                intent.putExtra("F_Name", get_f_name)
                intent.putExtra("L_Name", get_l_name)
                intent.putExtra("Email", getemail)
                intent.putExtra("Password", getPassword)
                intent.putExtra("R_Password", getRepeatPassword)
                startActivity(intent)
            }
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}