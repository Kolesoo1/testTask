package com.inikitin.testtask

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        var keepSplashOnScreen = true

        splashScreen.setKeepOnScreenCondition { keepSplashOnScreen }

        CoroutineScope(Dispatchers.Main).launch {
            delay(2500)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
            keepSplashOnScreen = false
        }
    }
}