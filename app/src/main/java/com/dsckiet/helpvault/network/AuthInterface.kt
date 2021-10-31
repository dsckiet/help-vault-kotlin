package com.dsckiet.helpvault.network

import com.dsckiet.helpvault.dataClass.LoginResponse
import com.dsckiet.helpvault.dataClass.UserLogin
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*


const val base_url: String = "https://help-vault-deploy.herokuapp.com/api/auth/"

interface AuthInterface {

    @POST("signin")
    fun login(@Body response : UserLogin): Call<LoginResponse>
}

object LoginService{
     val loginInstance : AuthInterface

    init {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        loginInstance = retrofit.create(AuthInterface::class.java)
    }

}