package com.cysj.zziririt.presentation.my_info

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
import com.cysj.zziririt.ui.theme.gmarketsans_bold
import com.cysj.zziririt.ui.theme.gmarketsans_light

@Composable
fun MenuItem(iconName: Int, text: String, onClick: () -> Unit,) {
    Row(modifier = Modifier
        .clickable { })
    {
        Image(
            painterResource(id = iconName), contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(end = 3.dp)
        )
        Text(
            text = text,
            color = Color.White,
            fontFamily = gmarketsans_light,
            modifier = Modifier
                .align(Alignment.CenterVertically)
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
fun TitleItemClickable (text: String,) {
    Text(text = text,
        color = Color.White,
        fontSize = 22.sp,
        fontFamily = gmarketsans_bold,
        modifier = Modifier
            .padding(top = 16.dp)
            .clickable { })
}

