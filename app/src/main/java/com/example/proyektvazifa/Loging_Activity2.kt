package com.example.proyektvazifa

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.provider.Telephony.Sms
import android.widget.Toast
import com.example.proyektvazifa.databinding.ActivityLoging2Binding
import com.example.proyektvazifa.databinding.ActivitySplash2Binding
import com.example.proyektvazifa.manager.SharedPreferences

class Loging_Activity2 : AppCompatActivity() {
    private lateinit var binding: ActivityLoging2Binding
    private lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoging2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreference = SharedPreferences(this)
        binding.btnGoogle.setOnClickListener {
            goToGoogle()
        }
        binding.btnPhone.setOnClickListener {
            goToCall()
        }
        binding.btnsms.setOnClickListener {
            goToSms()
        }

        binding.buttonEdit.setOnClickListener {
            val email = binding.editEmail.text.toString().trim()
            val pass = binding.editPassword.text.toString().trim()

            sharedPreference.saveData(email, pass)

            if (email.isNotBlank() && pass.isNotBlank()) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                Toast.makeText(this, "Malumotlar saqlandi!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Email da yoki passwortda hatolik!!", Toast.LENGTH_SHORT)
                    .show()

            }
        }
    }

    private fun goToGoogle() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com")
        startActivity(Intent.createChooser(intent, "bitmap"))
    }

    private fun goToCall() {
        val intent = Intent()
        intent.action = Intent.ACTION_DIAL
        startActivity(intent)
    }

    private fun goToSms() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.apply {
            type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share"))
        }
    }
}