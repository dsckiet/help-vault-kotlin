package com.dsckiet.helpvault.network

import retrofit2.http.POST

interface HelpVaultNetwork {

    @POST()
    fun login()
}