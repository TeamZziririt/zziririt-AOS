package com.cysj.zziririt.presentation.login

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cysj.zziririt.domain.model.OAuthLoginResult
import com.cysj.zziririt.domain.usecase.OAuthLoginUseCase
import com.cysj.zziririt.presentation.login.model.AuthState
import com.navercorp.nid.NaverIdLoginSDK
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
//    context: Context,
    private val oAuthLoginUseCase: OAuthLoginUseCase
) : ViewModel() {

    companion object {
        const val TAG = "LoginViewModel"
    }

    /*
    * Naver Login API */
    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState

    fun authenticate(context: Context) {
        viewModelScope.launch {
            oAuthLoginUseCase.execute(context).collect { result ->
                when (result) {
                    is OAuthLoginResult.Success -> {
                        _authState.value = AuthState.Success
                        Log.d(TAG, NaverIdLoginSDK.getAccessToken() ?: "null")
                    }
                    is OAuthLoginResult.Failure -> {
                        _authState.value = AuthState.Failure(result.errorCode, result.errorDescription)
                    }
                }
            }
        }
    }

}
