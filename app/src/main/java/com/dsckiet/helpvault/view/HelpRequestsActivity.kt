package com.dsckiet.helpvault.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dsckiet.helpvault.R
import com.dsckiet.helpvault.databinding.ActivityHelpRequestsBinding

class HelpRequestsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHelpRequestsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_requests)

    }
}