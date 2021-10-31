package com.dsckiet.helpvault.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dsckiet.helpvault.dataClass.LoginResponse
import com.dsckiet.helpvault.repository.AuthRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val repoInstance = AuthRepo()
    lateinit var loginResponse : Call<LoginResponse>
    val loginToken = MutableLiveData<LoginResponse>()

    fun login(email:String , password:String):MutableLiveData<LoginResponse>{
       this.loginResponse =  repoInstance.login(email, password)
        loginResponse.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
               loginToken.value =  response.body()
                Log.d("response", response.body().toString())
            }

            @SuppressLint("LogNotTimber")
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("batao", "Error in fetching: $t")
            }

        })
        return loginToken
    }
}