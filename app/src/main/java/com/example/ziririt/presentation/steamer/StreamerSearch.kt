package com.example.ziririt.presentation.steamer

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
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledTonalButton
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
import com.example.ziririt.R

@Composable
fun StreamerSearch() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(all = 8.dp)) {
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
            ) {
                Image(painterResource(id = R.drawable.writepost_x),
                    contentDescription = null)
                Text(text = "스트리머 게시판 신청하기",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                FilledTonalButton(onClick = { /*신청버튼*/ }) {
                    Text(text = "신청",
                        color = Color.Black,
                        textAlign = TextAlign.End)

                }
            }
            Divider(color = Color.Gray, thickness = 0.7.dp)
            Spacer(modifier = Modifier.height(16.dp))
        }

    }

}


@Preview
@Composable
fun StreamerSearchPreview() {
    StreamerSearch()
}