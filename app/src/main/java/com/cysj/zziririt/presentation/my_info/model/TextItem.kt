package com.cysj.zziririt.presentation.my_info.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cysj.zziririt.ui.theme.gmarketsans_bold
import com.cysj.zziririt.ui.theme.gmarketsans_medium



@Composable
fun MenuItem(
    iconName: Int,
    text: String,
    navController: NavController,
    route: String,
    modifier: Modifier
) {
    Row(modifier = Modifier
        .clickable { navController.navigate(route) }
        .padding(start = 8.dp, end = 5.dp, bottom = 8.dp))
    {
        Image(
            painterResource(id = iconName), contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        Text(
            text = text,
            color = Color.White,
            fontFamily = gmarketsans_medium,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 5.dp)
        )
    }
}

@Composable
fun TitleItem(text: String) {
    Text(text = text,
        color = Color.White,
        fontSize = 22.sp,
        fontFamily = gmarketsans_bold,
        modifier = Modifier.padding(bottom = 5.dp))
}

@Composable
fun TitleItemClickable (
    text: String
    ) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .clickable {  }
    ) {

    }
    Text(
        text = text,
        color = Color.White,
        fontSize = 22.sp,
        fontFamily = gmarketsans_bold,
        )
}

