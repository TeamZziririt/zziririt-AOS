package com.cysj.zziririt.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.cysj.zziririt.R

@Composable
fun LoginScreens() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141517)),
        contentAlignment = Alignment.Center
    ) {
        Column {
            // 화면
            Image(painterResource(id = R.drawable.back_btn) , contentDescription = null)
            Image(painterResource(id = R.drawable.zziririt_icon), contentDescription = null)
            Text(
                text = "로그인하고 찌리릿 서비스를 \n 자유롭게 사용해보세요",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Image(painterResource(id = R.drawable.naver_login_btn) , contentDescription = null )
        }
    }
}

@Preview
@Composable
fun LoginScreensPreview() {
    LoginScreens()
}