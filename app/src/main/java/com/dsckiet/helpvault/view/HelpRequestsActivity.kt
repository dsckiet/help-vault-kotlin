package com.dsckiet.helpvault.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dsckiet.helpvault.R
import com.dsckiet.helpvault.databinding.ActivityHelpRequestsBinding

class HelpRequestsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHelpRequestsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_help_requests)
        binding.backBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}