package com.example.proyektvazifa

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import com.example.proyektvazifa.manager.SharedPreferences
import android.widget.TextView
import android.widget.Toast
import com.example.proyektvazifa.databinding.ActivitySplash2Binding
import com.example.proyektvazifa.util.Constants.EMAIL
import com.example.proyektvazifa.util.Constants.PASS

class Splash_Activity2 : AppCompatActivity() {
    private lateinit var binding: ActivitySplash2Binding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplash2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        anim()

        sharedPreferences = SharedPreferences(this)
        val email = sharedPreferences.getData(EMAIL)
        val pass = sharedPreferences.getData(PASS)
        intent(email, pass)

    }

    private fun intent(email: String?, pass: String?) {

        object : CountDownTimer(2000, 1000) {

            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                if (email == null && pass == null) {
                    Intent(this@Splash_Activity2, Loging_Activity2::class.java).also {
                        startActivity(it)
                        finish()
                    }
                } else {
                    Intent(this@Splash_Activity2, MainActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }

                }
                startActivity(Intent(this@Splash_Activity2, Loging_Activity2::class.java))
                finish()
            }
        }.start()

    }

    private fun anim() {
        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
        binding.splash.startAnimation(anim)
    }
}