package com.cysj.zziririt.domain.model

sealed class OAuthLoginResult {
    object Success : OAuthLoginResult()
    data class Failure(
        val errorCode: String,
        val errorDescription: String,
    ) : OAuthLoginResult()
}