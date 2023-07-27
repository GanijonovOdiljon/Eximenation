package com.example.proyektvazifa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyektvazifa.databinding.ActivityCreate2Binding
import com.example.proyektvazifa.manager.SharedPreferences

class createActivity2 : AppCompatActivity() {

    private val binding by lazy { ActivityCreate2Binding.inflate(layoutInflater) }
    private lateinit var sharedpref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharedpref=  SharedPreferences(this)
        saveData()
    }
    private fun saveData(){
        binding.editButton.setOnClickListener {
            val email = binding.editEmail.text.toString().trim()
            val pass = binding.editPassword.text.toString().trim()
            val conPass = binding.editConiform.text.toString().trim()

            if (email.isNotBlank() && pass.isNotBlank() && conPass == conPass){
                sharedpref.saveData(email,pass)
                Toast.makeText(this, "Succesully Saved", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Enter data !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}