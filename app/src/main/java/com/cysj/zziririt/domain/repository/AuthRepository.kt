package com.cysj.zziririt.domain.repository

import android.content.Context
import com.cysj.zziririt.domain.model.OAuthLoginResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun authenticate(context: Context): Flow<OAuthLoginResult>
}