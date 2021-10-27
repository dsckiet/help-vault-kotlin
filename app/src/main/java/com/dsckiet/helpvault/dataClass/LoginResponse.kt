package com.dsckiet.helpvault.dataClass

data class LoginResponse(
    val msg: String,
    val token: String,
    val user: User
)