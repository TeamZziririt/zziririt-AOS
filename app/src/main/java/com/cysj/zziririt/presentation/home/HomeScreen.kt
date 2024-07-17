package com.cysj.zziririt.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.cysj.zziririt.R
import com.cysj.zziririt.presentation.main.MainViewModel
import com.cysj.zziririt.ui.theme.ZziriritTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val scrollState = rememberScrollState()

    // TODO ViewModel로 이동
    var expanded by remember { mutableStateOf(false) }

    // ViewModel에서 스트리머 정보 아이템 목록을 관찰
    val streamerInfoItems by homeViewModel.streamerInfoItems.collectAsState()
    val boardRankingInfoItems by homeViewModel.boardRankingInfoItems.collectAsState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141517))
            .padding(
                start = 16.dp,
                top = 8.dp,
                end = 16.dp
            )
            .verticalScroll(scrollState)
    ) {
        Column {
            // 최근 방문한 게시판 Text
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "최근 방문한 게시판",
                    color = Color.White,
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = { expanded = !expanded },
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_baseline_arrow_forward_ios_24
                        ), // 화살표 아이콘 리소스 ID
                        contentDescription = "Dropdown Arrow",
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            // 최근 방문 게시판 메인
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF303032),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(
                        vertical = 4.dp,
                        horizontal = 16.dp,
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (streamerInfoItems.isEmpty()) {
                    Column(
                        modifier = Modifier
                            .padding(
                                vertical = 16.dp,
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "앗! 최근 방문한 게시판이 없어요.\n좋아하는 스트리머의 게시판을 방문해보세요!",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = {
                                // TODO 스트리머 찾아보기 버튼 클릭 시 수행할 동작
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White,
                                disabledContainerColor = Color.Gray,
                                disabledContentColor = Color.White,
                            ),
                            border = BorderStroke(1.dp, Color(0xFFC1C1C1)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.padding(
                                top = 8.dp
                            )
                        ) {
                            Text(
                                text = "스트리머 찾아보기"
                            )
                        }
                    }
                } else {
                    StreamerInfoList(streamerInfoItems)
                }
            }


            // 실시간 게시판 랭킹 텍스트
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "실시간 게시판 랭킹",
                    color = Color.White,
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = { expanded = !expanded },
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_baseline_arrow_forward_ios_24
                        ), // 화살표 아이콘 리소스 ID
                        contentDescription = "랭킹 보기",
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            // 실시간 게시판 랭킹 메인
            BoardRankingInfoList(boardRankingInfoItems)
        }
    }
}

@Composable
fun StreamerInfoList(items: List<StreamerInfoItem>) {
    Column {
        items.take(5).forEach { item ->
            StreamerInfoRow(item)
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

/*
최근 방문한 스트리머 게시판 Info Row
*/
@Composable
fun StreamerInfoRow(streamer: StreamerInfoItem) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = streamer.name,
                color = Color(0xFF00FFA3),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "구독자 수 ${streamer.subscribers} ",
                color = Color.Gray,
                fontSize = 8.sp,
            )
        }

        Icon(
            painter = painterResource(
                id = if (streamer.isFollow) R.drawable.ic_baseline_star_24 else R.drawable.ic_baseline_star_border_24
            ), // 팔로우 여부에 따라 다른 아이콘 표시
            contentDescription = if (streamer.isFollow) "Following" else "Not Following",
            tint = if (streamer.isFollow) Color(0xFF00FFA3) else Color.Gray,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun BoardRankingInfoList(items: List<BoardRankingInfoItem>) {
    Column {
        items.take(10).forEach { item ->
            BoardRankingInfoRow(item)
            Spacer(
                modifier = Modifier.padding(
                    vertical = 4.dp
                )
            )
        }
    }
}

/*
실시간 인기 게시글 랭킹 Info Row
*/
@Composable
fun BoardRankingInfoRow(item: BoardRankingInfoItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF303032),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 8.dp,
                    horizontal = 16.dp,
                )
        ) {
            Text(
                text = "${item.rank}",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = "User Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp)
                    .clip(RoundedCornerShape(24.dp))
            )
            Spacer(modifier = Modifier.padding(4.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.username,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // 미리보기용으로 ViewModel을 직접 생성
    val previewViewModel = MainViewModel().apply {
        setItems(listOf("home", "board", "search", "my_info"))
    }

    ZziriritTheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}
