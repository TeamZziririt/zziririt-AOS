package com.example.ziririt.presentation.my_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ziririt.R

@Composable
fun SettingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // BoardScreen의 내용
        Column {
            Text(text = "환경설정", color = Color.White)

            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.Gray, thickness = 0.5.dp)

            Row {
                    Image(
                        painterResource(id = R.drawable.profile_bell),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(24.dp),
                    )
                    Text(text = "알림설정", color = Color.White)
            } //row 1

            Row {
                Image(
                    painterResource(id = R.drawable.profile_edit),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(24.dp),
                )
                Text(text = "프로필 수정", color = Color.White)
            } //row 2

            Row {
                Image(
                    painterResource(id = R.drawable.profile__informantion),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(24.dp),
                )
                Text(text = "로그인 정보", color = Color.White)
            } //row 3

        } // Column
    } // box
}

@Preview
@Composable
fun SettingScreenScreen() {
    SettingScreen()
}