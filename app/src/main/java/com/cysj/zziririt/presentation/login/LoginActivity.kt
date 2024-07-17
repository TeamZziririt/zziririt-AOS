package com.cysj.zziririt.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cysj.zziririt.R
import com.cysj.zziririt.presentation.main.MainActivity
import com.cysj.zziririt.ui.theme.ZziriritTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // viewmodel 초기화
        initModel()

        setContent {
            ZziriritTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(loginViewModel)
                }
            }
        }
    }

    private fun initModel() = with(loginViewModel) {
        loginSuccess.observe(this@LoginActivity) { result ->
            if (result) {
                //MainActivity로 이동...
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@LoginActivity, R.string.login_fail, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
