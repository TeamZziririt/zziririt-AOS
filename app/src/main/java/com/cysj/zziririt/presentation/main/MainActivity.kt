package com.cysj.zziririt.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.cysj.zziririt.ui.theme.ZziriritTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 모델 초기화
        initModel()

        setContent {
            ZziriritTheme {
                val color = Color(0xFF141517)
                SideEffect {
                    val window = this@MainActivity.window
                    window.statusBarColor = color.toArgb()
                    WindowCompat.getInsetsController(
                        window,
                        window.decorView
                    ).isAppearanceLightStatusBars = true
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MainScreen(navController, mainViewModel)
                }
            }
        }
    }

    private fun initModel() = with(mainViewModel) {
        // TODO 임시 테스트 -> 교체 예정
        setItems(listOf("home", "board", "search", "my_info"))
    }
}
