package com.cysj.zziririt.presentation.my_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.cysj.zziririt.ui.theme.ZziriritTheme
import com.cysj.zziririt.R
import com.cysj.zziririt.ui.theme.gmarketsans_medium
import androidx.navigation.compose.composable
import com.cysj.zziririt.presentation.main.Screen


@Composable
fun MyInfoScreen(navController: NavController) {
    Box(modifier = Modifier.background(Color.Black)) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,

    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End ) {
            Image(
                painterResource(id = R.drawable.ic_setting_line),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                    navController.navigate(Screen.Setting.route)
                }

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

        Divider(
            color = Color.White,
            thickness = 0.5.dp,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                TitleItem(text = "나의 찌리릿")

                MenuItem(
                    iconName = R.drawable.ic_mypage_write,
                    text = "내가 작성한 게시글",
                    navController = navController,
                    route = Screen.LoginInformation.route,
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.ProfileSetting.route)
                    }
                )
                MenuItem(
                    iconName = R.drawable.ic_mypage_comment,
                    text = "내가 작성한 댓글",
                    navController = navController,
                    route = Screen.LoginInformation.route,
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.ProfileSetting.route)
                    }
                )
                MenuItem(
                    iconName = R.drawable.ic_mypage_fire,
                    text = "내가 찌리릿한 게시글",
                    navController = navController,
                    route = Screen.LoginInformation.route,
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.ProfileSetting.route)
                    }
                )
                MenuItem(
                    iconName = R.drawable.ic_mypage_heart,
                    text = "내가 찌리릿한 댓글",
                    navController = navController,
                    route = Screen.LoginInformation.route,
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.ProfileSetting.route)
                    }
                )
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
                TitleItem(text = "찌리릿 소식")

                MenuItem(iconName = R.drawable.ic_mypage_notice, text = "공지사항", navController = navController,
                    route = Screen.LoginInformation.route,
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.ProfileSetting.route)
                    })
                MenuItem(iconName = R.drawable.ic_mypage_event, text = "이벤트", navController = navController,
                    route = Screen.LoginInformation.route,
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.ProfileSetting.route)
                    })
                MenuItem(
                    iconName = R.drawable.ic_mypage_iconshop,
                    text = "아이콘샵",
                    navController = navController,
                    route = Screen.LoginInformation.route,
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.ProfileSetting.route)
                    }
                )

                Spacer(modifier = Modifier.width(5.dp))

                TitleItemClickable("약관 및 정책")
                Spacer(modifier = Modifier.width(50.dp))
                TitleItemClickable("건의 / 신고")
            }
        } // box3
    } //column
    }
}




@Preview
@Composable
fun MyInfoScreenPreview() {
    val navController = rememberNavController()

    ZziriritTheme {
        val navController = rememberNavController()
        MyInfoScreen(navController)
    }
}

