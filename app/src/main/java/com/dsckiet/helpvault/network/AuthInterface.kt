package com.dsckiet.helpvault.network

import com.dsckiet.helpvault.dataClass.LoginResponse
import com.dsckiet.helpvault.dataClass.UserLogin
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


const val base_url: String = "https://help-vault-deploy.herokuapp.com/"

interface AuthInterface {

    @POST("api/auth/signin")
    fun login(@Body request : UserLogin): Call<LoginResponse>
}

object LoginService{
     val loginInstance : AuthInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        loginInstance = retrofit.create(AuthInterface::class.java)
    }

}