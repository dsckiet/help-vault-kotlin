package com.dsckiet.helpvault.repository

import com.dsckiet.helpvault.dataClass.LoginResponse
import com.dsckiet.helpvault.dataClass.UserLogin
import com.dsckiet.helpvault.network.AuthInterface
import com.dsckiet.helpvault.network.LoginService
import retrofit2.Call

class AuthRepo {
    fun login(email:String , password:String):Call<LoginResponse>{
        return LoginService.loginInstance.login(UserLogin(email, password))
    }
}