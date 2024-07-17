package com.cysj.zziririt.presentation.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cysj.zziririt.ui.theme.ZziriritTheme

@Composable
fun BoardScreen(
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
fun BoardScreenPreview() {
    ZziriritTheme {
        val navController = rememberNavController()
        BoardScreen(navController)
    }
}

