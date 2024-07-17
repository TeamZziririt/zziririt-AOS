package com.example.ziririt.presentation.my_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ziririt.ui.theme.ZiriritTheme

@Composable
fun MyInfoScreen(
    navController: NavController,
    ) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141517)) // 동일한 배경 색상 설정
    ) {
        // BoardScreen의 내용
    }
}

@Preview(showBackground = true)
@Composable
fun MyInfoScreenPreview() {
    val navController = rememberNavController()

    ZiriritTheme {
        MyInfoScreen(navController)
    }
}

