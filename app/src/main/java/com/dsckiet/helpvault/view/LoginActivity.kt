package com.dsckiet.helpvault.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.dsckiet.helpvault.R
import com.dsckiet.helpvault.databinding.ActivityLoginBinding
import com.dsckiet.helpvault.util.SessionManager
import com.dsckiet.helpvault.viewModel.LoginViewModel
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var validate: Boolean = true
    lateinit var sessionManager: SessionManager
    private val viewModel: LoginViewModel by viewModels()
    private val PASSWORD_PATTERN = Pattern.compile(
        "^" + "(?=.*[0-9])" + "(?=.*[A-Z])" + ".{8,20}" + "$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        sessionManager = SessionManager(this)
        binding.btnLogIn.setOnClickListener {
            val isValidate = checkValidation(
                binding.emailInput.text.toString(),
                binding.password.text.toString()
            )
            if (isValidate) {
                viewModel.login(
                    binding.emailInput.text.toString(),
                    binding.password.text.toString()
                ).observe(this , Observer {
                    if(it != null) {
                        val token = it.data.token
                        sessionManager.saveAuthToken(token)
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                })
            }
        }
        binding.signUpText.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun checkValidation(email: String, pass: String): Boolean {

        if (email.isEmpty()) {
            binding.emailInput.error = "Email is Mandatory"
            binding.emailInput.requestFocus()
            validate = false
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                validate = false
                binding.emailInput.error = "Please enter valid email"
                binding.emailInput.requestFocus()
            } else {
                if (pass.isEmpty()) {
                    validate = false
                    binding.password.setError("Password is Mandatory", null)
                    binding.password.requestFocus()
                }
            }
        }
        //check login is valid or not here
        return validate
    }
}