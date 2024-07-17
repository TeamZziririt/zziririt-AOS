package com.example.ziririt.presentation.postcontent

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ziririt.R
import com.example.ziririt.ui.theme.ZiriritTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostContentScreen(
    navController: NavController,
//    postContentViewModel: PostContentViewModel,
) {
    val pageCount = 5  // 슬라이더에 표시할 페이지 수
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pageCount })


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141517))
            .padding(
                start = 16.dp,
                top = 8.dp,
                end = 16.dp
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {
                        // TODO 클릭 시 돌아가기
                    },
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_baseline_arrow_back_ios_24
                        ),
                        contentDescription = "Dropdown Arrow",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(8.dp)) // 아이콘과 텍스트 사이의 간격

                Text(
                    text = "스트리머 전체글",
                    color = Color.White,
                    fontSize = 24.sp,
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 제목
            Text(
                text = "게시물 제목",
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                    )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 작성자 정보 및 저장
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding
                        (
                        horizontal = 8.dp,
                    )
            ) {
                // 이미지
                Image(
                    painter = painterResource(
                        id = R.drawable.img
                    ),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape) // 이미지를 원형으로 자르기
                )

                Spacer(modifier = Modifier.width(8.dp)) // 이미지와 닉네임/작성 시간 간의 간격

                // 닉네임과 작성 시간을 포함하는 Column
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "닉네임",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "작성 시간",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }

                // 아이콘 1
                IconButton(
                    onClick = {
                        // TODO 아이콘 1 클릭 시 동작
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_bookmark_border_24), // 예시 아이콘 리소스
                        contentDescription = "Favorite Icon",
                        tint = Color.White
                    )
                }

                // 아이콘 2
                IconButton(
                    onClick = {
                        // TODO 아이콘 2 클릭 시 동작
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_pending_24), // 예시 아이콘 리소스
                        contentDescription = "Share Icon",
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            // 본문 내용
            Text(
                text = "이곳에 게시글 본문 내용이 들어갑니다. 여러 줄의 텍스트가 포함될 수 있습니다.",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 이미지 슬라이더
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) { page ->
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), // 예시 이미지 리소스
                    contentDescription = "Image $page",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PostContentScreenPreview() {

    val previewViewModel = PostContentViewModel().apply {

    }

    val navController = rememberNavController()

    ZiriritTheme {
        PostContentScreen(navController)
    }
}

