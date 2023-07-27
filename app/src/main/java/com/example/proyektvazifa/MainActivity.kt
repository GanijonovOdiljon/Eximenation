package com.example.proyektvazifa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyektvazifa.databinding.ActivityMainBinding
import com.example.proyektvazifa.manager.SharedPreferences
import com.example.proyektvazifa.util.Constants

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreference = SharedPreferences(this)

        val email = sharedPreference.getData(Constants.EMAIL)
        val pass = sharedPreference.getData(Constants.PASS)

        binding.text2.text = email
        binding.text1.text = pass

        binding.button.setOnClickListener {
            sharedPreference.clear()
            finish()
        }
    }
}