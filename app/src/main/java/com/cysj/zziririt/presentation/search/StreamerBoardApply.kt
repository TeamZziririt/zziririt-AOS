package com.cysj.zziririt.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cysj.zziririt.R
import com.cysj.zziririt.Zziririt
import com.cysj.zziririt.ui.theme.Zziririt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StreamerBoardApplyScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column {
            val interactionSource = remember { MutableInteractionSource() } // 상호작용 상태 추적 객체 생성 및 기억
            val isPressed by interactionSource.collectIsPressedAsState() // 버튼 클릭 여부 state로 수집
            val bgColor = if(isPressed) Zziririt else Color.White
            val contentColor = if (isPressed) Zziririt else Color.Gray

            // Row1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painterResource(id = R.drawable.ic_write_x),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                )
                Text(
                    text = "스트리머 게시판 신청하기",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                )
                FilledTonalButton(
                    onClick = { /*신청버튼*/ },
                    interactionSource = interactionSource,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = contentColor,
                        containerColor = if (isPressed) Zziririt else Color.White,
                    )
                ) {
                    Text(
                        text = "신청",
                        color = Color.Black,
                        textAlign = TextAlign.End
                    )
                }
            } // row1

            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.Gray, thickness = 0.7.dp)
            Spacer(modifier = Modifier.height(16.dp))

            //Column2
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
            ) {
                Text(
                    text = "스트리머 이름",
                    color = Color.White,
                    fontSize = 15.sp
                )

                var text by remember { mutableStateOf("") }

                TextField(
                    value = text,
                    onValueChange = { newText -> text = newText },
                    label = { Text("스트리머 이름을 입력해주세요") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent
                    )
                )
            } //Column2

            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.Gray, thickness = 0.7.dp)
            Spacer(modifier = Modifier.height(16.dp))

            // Column3
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
            ) {
                Text(
                    text = "신청하고자 하는 URL",
                    color = Color.White,
                    fontSize = 15.sp
                )

                var text by remember { mutableStateOf("") }

                TextField(
                    value = text,
                    onValueChange = { newText -> text = newText },
                    label = { Text("URL 주소 (영어 대소문자만 가능") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent
                    )
                )
            } //Column3


            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.Gray, thickness = 0.7.dp)
            Spacer(modifier = Modifier.height(16.dp))

            Column {
                // row4
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                ) {
                    Text(
                        text = "게시판 대표 이미지",
                        color = Color.White,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                    Image(painterResource(id = R.drawable.ic_writepage_photo), contentDescription = null,
                        modifier = Modifier
                            .size(24.dp))

                } //row 4
            }

        } // column

    }
}


@Preview
@Composable
fun StreamerBoardApplyPreview() {
    val navController = rememberNavController()
    StreamerBoardApplyScreen(navController)
}