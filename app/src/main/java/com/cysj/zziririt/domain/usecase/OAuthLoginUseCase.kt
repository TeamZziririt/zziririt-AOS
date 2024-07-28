package com.cysj.zziririt.domain.usecase

import android.content.Context
import com.cysj.zziririt.domain.model.OAuthLoginResult
import com.cysj.zziririt.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OAuthLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend fun execute(context: Context): Flow<OAuthLoginResult> {
        return authRepository.authenticate(context)
    }
}