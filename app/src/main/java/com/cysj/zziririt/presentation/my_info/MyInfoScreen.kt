package com.cysj.zziririt.presentation.my_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cysj.zziririt.ui.theme.ZziriritTheme
import com.cysj.zziririt.R
import com.cysj.zziririt.ui.theme.gmarketsans_bold
import com.cysj.zziririt.ui.theme.gmarketsans_light
import com.cysj.zziririt.ui.theme.gmarketsans_medium

@Composable
fun MyInfoScreen(
    navController: NavHostController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.Start
    ) {
        Column(horizontalAlignment = Alignment.End) {
            Image(
                painterResource(id = R.drawable.ic_setting_line),
                contentDescription = null,
                // 맨 오른쪽으로
                modifier = Modifier.clickable {  }
            )
        }
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
                    painterResource(id = R.drawable.ic_profie_logo),
                    contentDescription = null
                )

                Text(
                    text = "대니주", modifier = Modifier.padding(top = 8.dp), color = Color.White,
                    fontFamily = gmarketsans_medium
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Divider(color = Color.White, thickness = 0.5.dp)


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                Text(
                    text = "나의 찌리릿",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontFamily = gmarketsans_bold,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                MenuItem(iconName = R.drawable.ic_mypage_write, text = "내가 작성한 게시글",) {}
                MenuItem(iconName = R.drawable.ic_mypage_comment, text = "내가 작성한 댓글") {}
                MenuItem(iconName = R.drawable.ic_mypage_fire, text = "내가 찌리릿한 게시글") {}
                MenuItem(iconName = R.drawable.ic_mypage_heart, text = "내가 찌리릿한 댓글") {}
            }
        } // box2

        Spacer(modifier = Modifier.width(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                Text(
                    text = "찌리릿 소식",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontFamily = gmarketsans_bold,
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                MenuItem(iconName = R.drawable.ic_mypage_notice, text = "공지사항") {}
                MenuItem(iconName = R.drawable.ic_mypage_event, text = "이벤트") {}
                MenuItem(iconName = R.drawable.ic_mypage_iconshop, text = "아이콘샵") {}

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "약관 및 정책",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = gmarketsans_bold,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .clickable { }

                )

                Spacer(modifier = Modifier.width(50.dp))

                Text(
                    text = "건의 / 신고",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = gmarketsans_bold,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .clickable { }
                )
            }

        } // box3
    } //column
}

@Preview
@Composable
fun MyInfoScreenPreview() {
    val navController = rememberNavController()

    ZziriritTheme {
        MyInfoScreen(navController)
    }
}

