package com.example.ziririt.presentation.my_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ziririt.ui.theme.ZiriritTheme

@Composable
fun MyInfoScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            // BoardScreen의 내용
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 24.dp, bottom = 8.dp, end = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally// Column 내 항목들 수직으로 가운데 정렬
            ) {
                Image(
                    painterResource(id = com.example.ziririt.R.drawable.profile_setting),
                    contentDescription = null
                )
                Image(
                    painterResource(id = com.example.ziririt.R.drawable.profile_image),
                    contentDescription = null
                )

                Text(text = "유저닉네임임", modifier = Modifier.padding(top = 8.dp), color = Color.White)
                //
            }
        }

            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.White, thickness = 0.5.dp)


        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
            contentAlignment = Alignment.CenterStart) {
            Column {
                Text(text = "나의 찌리릿", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Row {
                    Image(
                        painterResource(id = com.example.ziririt.R.drawable.profile__mypost),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(24.dp),
                    )
                    Text(text = "내가 작성한 게시글", color = Color.White)
                } // row1

                Row {
                    Image(
                        painterResource(id = com.example.ziririt.R.drawable.profile__mypost),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(24.dp),
                    )
                    Text(text = "내가 작성한 댓글", color = Color.White)
                } // row2

                Row {
                    Image(
                        painterResource(id = com.example.ziririt.R.drawable.profile__mypost),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(24.dp),
                    )
                    Text(text = "내가 찌리릿한 게시글", color = Color.White)
                } // row3

                Row {
                    Image(
                        painterResource(id = com.example.ziririt.R.drawable.profile__mypost),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(24.dp),
                    )
                    Text(text = "내가 찌리릿한 댓글", color = Color.White)
                } // row4
            }

        } // box2
    } //column
}

@Preview
@Composable
fun MyInfoScreenPreview() {
    ZiriritTheme {
        MyInfoScreen()
    }
}

