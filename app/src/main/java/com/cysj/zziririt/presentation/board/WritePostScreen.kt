package com.cysj.zziririt.presentation.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cysj.zziririt.R
import com.cysj.zziririt.ui.theme.ZziriritTheme
import com.cysj.zziririt.ui.theme.gmarketsans_bold
import com.cysj.zziririt.ui.theme.gmarketsans_light
import com.cysj.zziririt.ui.theme.gmarketsans_medium

@Composable
fun WritePostScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 8.dp)
    ) {
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Row(modifier = Modifier
                    .heightIn(min = 56.dp)
                    .align(Alignment.CenterVertically)) {
                    Image(
                        painterResource(id = R.drawable.ic_write_x),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .align(Alignment.CenterVertically)
                    )

                    Text(text = "글쓰기", color = Color.White, fontSize = 25.sp,
                        fontFamily = gmarketsans_bold)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { /*저장버튼*/ }) {
                        Text(text = "저장", fontFamily = gmarketsans_medium)
                    }
                    FilledTonalButton(onClick = { /*등록 버튼*/ }) {

                        Text(text = "등록",fontFamily = gmarketsans_medium)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.Gray, thickness = 0.7.dp)
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "제목을 입력해주세요", color = Color.White, fontFamily = gmarketsans_light)
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.Gray, thickness = 0.7.dp)

            Image(
                painterResource(id = R.drawable.ic_writepage_photo),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(top = 8.dp, start = 16.dp, bottom = 8.dp)
            )
            Text(text = "내용을 입력해주세요", color = Color.White, fontFamily = gmarketsans_light)
        } //column

    }

}

@Preview
@Composable
fun WritePostScreenPreview() {
    ZziriritTheme {
        WritePostScreen()
    }
}