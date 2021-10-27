package com.dsckiet.helpvault.viewModel

import androidx.lifecycle.ViewModel
import com.dsckiet.helpvault.dataClass.LoginResponse
import com.dsckiet.helpvault.repository.AuthRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val repoInstance = AuthRepo()
    lateinit var loginResponse : Call<LoginResponse>

    fun login(email:String , password:String){
       this.loginResponse =  repoInstance.login(email, password)
        loginResponse.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}