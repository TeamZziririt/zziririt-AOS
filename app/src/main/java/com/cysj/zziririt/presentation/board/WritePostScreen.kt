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

@Composable
fun WritePostScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 8.dp)
    ) {
        Column {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painterResource(id = R.drawable.writepost_x),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(35.dp)
                        .padding(end = 16.dp)
                        .align(Alignment.CenterVertically),
                )

                Text(text = "글쓰기", color = Color.White, fontSize = 15.sp)
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { /*저장버튼*/ }) {
                        Text(text = "저장")
                    }
                    FilledTonalButton(onClick = { /*등록 버튼*/ }) {

                        Text(text = "등록")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.Gray, thickness = 0.7.dp)
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "제목을 입력해주세요", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.Gray, thickness = 0.7.dp)

            Image(
                painterResource(id = R.drawable.ic_writepage_photo),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(top = 8.dp, start = 16.dp, bottom = 8.dp)
            )
            Text(text = "내용을 입력해주세요", color = Color.White)
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