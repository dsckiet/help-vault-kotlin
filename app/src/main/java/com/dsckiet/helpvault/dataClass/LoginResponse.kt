package com.dsckiet.helpvault.dataClass

data class LoginResponse(
    val data: Data,
    val error: Boolean,
    val message: String
)