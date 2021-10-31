package com.dsckiet.helpvault.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dsckiet.helpvault.R
import com.dsckiet.helpvault.databinding.ActivitySplashBinding
import com.dsckiet.helpvault.util.SessionManager

class SplashActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashBinding
    lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash)
        sessionManager = SessionManager(this)
        binding.btnCreateAccount.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.loginText.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        if (sessionManager.fetchAuthToken(SessionManager.USER_TOKEN) != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}