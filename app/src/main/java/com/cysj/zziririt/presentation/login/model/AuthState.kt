package com.cysj.zziririt.presentation.login.model

sealed class AuthState {
    object Idle : AuthState()
    object Success : AuthState()
    data class Failure(
        val errorCode: String,
        val errorDescription: String,
    ) : AuthState()
}