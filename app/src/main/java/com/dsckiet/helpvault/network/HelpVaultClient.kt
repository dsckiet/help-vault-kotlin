package com.dsckiet.helpvault.network

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object HelpVaultClient {
    private const val BASE_URL = "https://localhost:800"
    fun getClient(context: Context): HelpVaultNetwork {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val httpClient = OkHttpClient.Builder()
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(httpClient)
            .build()


        val retrofitService: HelpVaultNetwork by lazy {
            retrofit.create(HelpVaultNetwork::class.java)
        }
        return retrofitService
    }

}