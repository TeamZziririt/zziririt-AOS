package com.cysj.zziririt.data.repository

import android.content.Context
import com.cysj.zziririt.domain.model.OAuthLoginResult
import com.cysj.zziririt.domain.repository.AuthRepository
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    override suspend fun authenticate(context: Context): Flow<OAuthLoginResult> = callbackFlow {

        /*
        * 결과를 받아올 callback 객체 생성 */
        val callback = object : OAuthLoginCallback {
            override fun onSuccess() {
                trySend(OAuthLoginResult.Success).isSuccess
            }

            override fun onFailure(httpStatus: Int, message: String) {
                val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                trySend(OAuthLoginResult.Failure(errorCode, errorDescription ?: "null")).isSuccess
            }

            override fun onError(errorCode: Int, message: String) {
                onFailure(errorCode, message)
            }
        }

        NaverIdLoginSDK.authenticate(context, callback)

        awaitClose {
            // 필요 시 리소스 정리 작업을 여기에 추가
        }
    }
}