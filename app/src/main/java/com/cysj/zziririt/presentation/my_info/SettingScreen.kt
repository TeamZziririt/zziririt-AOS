package com.cysj.zziririt.presentation.my_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cysj.zziririt.R
import com.cysj.zziririt.presentation.main.Screen
import com.cysj.zziririt.ui.theme.gmarketsans_medium

@Composable
fun SettingScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // BoardScreen의 내용
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp), // 원하는 높이 설정
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painterResource(id = R.drawable.ic_back_btn),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "환경설정",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontFamily = gmarketsans_medium,
                    fontSize = 20.sp,
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = Color.Gray, thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                MenuItem(
                    iconName = R.drawable.ic_settings_bell, text = "알림설정", navController = navController, route = Screen.LoginInformation.route,
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.ProfileSetting.route)
                    })

                Column {
                    Image(painterResource(id = R.drawable.ic_settings_information),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 8.dp, bottom = 8.dp)
                            .clickable { navController.navigate(Screen.LoginInformation.route) })

                    Column {
                        Image(painterResource(id = R.drawable.ic_settings_profile_edit),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 8.dp, bottom = 8.dp)
                                .clickable { navController.navigate(Screen.ProfileSetting.route) })

                        MenuItem2(iconName = R.drawable.ic_settings_profile_edit,
                            text = "프로필 수정2",
                            modifier = Modifier.clickable {
                                navController.navigate(Screen.ProfileSetting.route)
                            }) /// 왜 안보영
                    }

                    MenuItem(
                        iconName = R.drawable.ic_settings_profile_edit,
                        text = "프로필 수정",
                        navController = navController,
                        route = Screen.ProfileSetting.route,
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.ProfileSetting.route)
                        }

                    )
                    MenuItem(
                        iconName = R.drawable.ic_settings_information,
                        text = "로그인 정보",
                        navController = navController,
                        route = Screen.LoginInformation.route,
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.ProfileSetting.route)
                        }

                    )
                }

            } // Column
        } // boxnavController

    }
}
@Preview
@Composable
fun SettingScreenScreenPreview() {
    val navController = rememberNavController()
    SettingScreen(navController)
}