package com.cysj.zziririt.presentation.my_info.setting

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cysj.zziririt.R
import com.cysj.zziririt.presentation.main.Screen
import com.cysj.zziririt.presentation.my_info.model.MenuItem
import com.cysj.zziririt.ui.theme.gmarketsans_medium

@Composable
fun LoginInformationScreen(navController: NavController) {
    Box(modifier = Modifier.background(Color.Black)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp), // 원하는 높이 설정
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_back_btn), contentDescription = null,
                        modifier = Modifier.clickable { navController.popBackStack() },
                    )
                    Text(
                        text = "로그인 정보",
                        fontWeight = FontWeight.Bold,
                        fontFamily = gmarketsans_medium,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center
                    )
                }
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(color = Color.Gray, thickness = 0.5.dp)
                    Spacer(modifier = Modifier.height(16.dp))

                    MenuItem(
                        iconName = R.drawable.ic_red_x_center, text = "회원 탈퇴",
                        navController = navController,
                        route = "login_information",
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.ProfileSetting.route)
                        }
                    )

        } //전체 c
    }
}


}


@Preview
@Composable
fun LoginInformationScreenPreview() {
    val navController = rememberNavController()
    LoginInformationScreen(navController)
}