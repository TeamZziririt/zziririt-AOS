package com.cysj.zziririt.presentation.postcontent

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.rememberNavController
import com.cysj.zziririt.R
import com.cysj.zziririt.presentation.board.model.PostItem
import com.cysj.zziririt.ui.theme.ZziriritTheme
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostContentScreen(
    navController: NavController,
    postContentViewModel: PostContentViewModel = hiltViewModel(),
) {
    val pageCount = 5  // 슬라이더에 표시할 페이지 수
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pageCount })

    val comments by postContentViewModel.comments.observeAsState(emptyList())

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

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
        ) {

            item {
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
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }


            /*
            * 제목, 작성자 정보, 글 내용 */
            item {
                // TODO 임시 테스트
                PostItemWidget(
                    PostItem.DetailPostItem(
                        id = 0,
                        title = "Title ${Random.nextInt(1, 100)}",
                        imageRes = 0,
                        name = "User ${Random.nextInt(1, 100)}",
                        date = "2024-07-${Random.nextInt(1, 30).toString().padStart(2, '0')}",
                        commentNum = Random.nextInt(0, 100),
                        content = "This is a sample content with id 0",
                        imageResList = List(Random.nextInt(1, 10)) { Random.nextInt(1, 1000) },
                        onFavoriteClick = { println("Favorite clicked for post 0") },
                        onShareClick = { println("Share clicked for post 0") }
                    )
                )
            }

            // 좋아요 표시 이미지
            item {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_note_zziririt),
                            contentDescription = "Zziririt",
                            modifier = Modifier.size(48.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "5명이 찌리릿했어요!",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Divider(color = Color.Gray, thickness = 0.7.dp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }


            /*
            * 댓글 */
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = "댓글 (${comments.size})",
                        color = Color.White,
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            items(comments) { comment ->
                // 댓글 리스트
                CommentRow(comment = comment)
            }
        }

    }
}

@Composable
fun PostItemWidget(
    detailPostItem: PostItem.DetailPostItem,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // 제목
        Text(
            text = detailPostItem.title,
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 작성자 정보 및 저장
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            // 이미지
            Image(
                painter = painterResource(id = detailPostItem.imageRes),
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
                    text = detailPostItem.name,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = detailPostItem.date,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            // 아이콘 1
            IconButton(
                onClick = detailPostItem.onFavoriteClick
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_bookmark_border_24), // 예시 아이콘 리소스
                    contentDescription = "Favorite Icon",
                    tint = Color.White
                )
            }

            // 아이콘 2
            IconButton(
                onClick = detailPostItem.onShareClick
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
            text = detailPostItem.content,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 이미지 슬라이더
        val pagerState = rememberPagerState {
            0
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) { page ->
            Image(
                painter = painterResource(id = detailPostItem.imageResList[page]), // 예시 이미지 리소스
                contentDescription = "Image $page",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Composable
fun CommentRow(comment: CommentItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        // 이미지
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // 닉네임과 작성 시간을 포함하는 Column
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = comment.nickname,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = comment.time,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            // 댓글 텍스트
            Text(
                text = comment.text,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
        }

        // 더보기 버튼
        IconButton(
            onClick = {
                // TODO IC SEE MORE 클릭 시 동작
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_pending_24),
                contentDescription = "See More",
                tint = Color.White
            )
        }
    }
}

@Composable
fun CommentList(comments: List<CommentItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(comments) { comment ->
            CommentRow(comment)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostContentScreenPreview() {

    val previewComments = listOf(
        CommentItem(
            "닉네임1",
            "1시간 전",
            "위 코드에서 LazyColumn의 modifier에 weight(1f)를 추가하여 높이 제약을 설정했습니다. 이렇게 하면 LazyColumn이 무한한 높이 제약 조건으로 측정되지 않도록 보장할 수 있습니다."
        ),
        CommentItem("닉네임2", "2시간 전", "댓글 내용2"),
        CommentItem("닉네임3", "7시간 전", "댓글 내용3"),
        CommentItem("닉네임4", "7시간 전", "댓글 내용4"),
        CommentItem("닉네임5", "7시간 전", "댓글 내용5"),
    )

    val previewViewModel = PostContentViewModel().apply {
        setComments(previewComments)
    }

    val navController = rememberNavController()

    ZziriritTheme {
        PostContentScreen(
            navController,
            previewViewModel
        )
    }
}
