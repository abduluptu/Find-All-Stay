package com.sohainfotech.findallstay.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import com.sohainfotech.findallstay.R
import com.sohainfotech.findallstay.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    // Splash screen timer
    private val SPLASH_TIME_OUT = 3000L

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_splash)

       /* CoroutineScope(Dispatchers.Main).launch {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            delay(5000) //5 seconds
            Log.d("SplashActivity", "this is ${Thread.currentThread().name}")
            finish()
        }*/


        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT) // 3000 is the delayed time in milliseconds.

    }
}