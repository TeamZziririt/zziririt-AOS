package com.example.ziririt.presentation.board.streamer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ziririt.R
import com.example.ziririt.ui.theme.ZiriritTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StreamerScreen(
    navController: NavController,
) {


    // TODO ViewModel로 이동
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("항목 1", "항목 2", "항목 3")
    var selectedItem by remember { mutableStateOf("") }
    var searchText by remember { mutableStateOf("") } // 검색어 상태 추가
    var selectedText by remember { mutableStateOf("최신순") }

    val postItems = listOf(
        PostItem(
            image = R.drawable.img,
            title = "게시글 제목1",
            commentNum = 5,
            name = "작성자 이름",
            date = "2023-07-09"
        ),
        PostItem(
            image = R.drawable.img,
            title = "게시글 제목2",
            commentNum = 2,
            name = "작성자 이름",
            date = "2023-07-10"
        ),
        PostItem(
            image = R.drawable.img,
            title = "게시글 제목3",
            commentNum = 4,
            name = "훈이좋아",
            date = "2023-07-11"
        ),

        )


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
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "스트리머 전체글",
                    color = Color.White,
                    fontSize = 24.sp,
                )
                IconButton(
                    onClick = { expanded = !expanded },
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_baseline_arrow_drop_down_24
                        ), // 화살표 아이콘 리소스 ID
                        contentDescription = "Dropdown Arrow",
                        tint = Color.White
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    items.forEach { item ->
                        DropdownMenuItem(
                            onClick = {
                                selectedItem = item
                                expanded = false
                            },
                            text = {
                                Text(text = item)
                            },
                        )
                    }
                }
            }


            // 검색 박스
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(48.dp)
                    .background(
                        color = Color(0xFF303032),
                        shape = RoundedCornerShape(12.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .background(
                            color = Color(0xFF303032),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent, // 포커스 시 인디케이터 색상 투명
                        unfocusedIndicatorColor = Color.Transparent // 비포커스 시 인디케이터 색상 투명
                    )
                )
                IconButton(
                    onClick = {
                        // TODO 검색 기능 추가
                    },
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
            }


            // 최신순, 인기순 선택
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (selectedText == "최신순") {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_check_24), // 체크 아이콘 리소스 사용
                        contentDescription = null,
                        tint = Color(0xFF00FFA3),
                    )
                    Text(
                        text = "최신순",
                        modifier = Modifier
                            .clickable { selectedText = "최신순" }
                            .padding(8.dp),
                        color = Color(0xFF00FFA3)
                    )
                    Text(
                        text = "인기순",
                        modifier = Modifier
                            .clickable { selectedText = "인기순" }
                            .padding(8.dp),
                        color = Color(0xFF535353)
                    )
                } else {
                    Text(
                        text = "최신순",
                        modifier = Modifier
                            .clickable { selectedText = "최신순" }
                            .padding(8.dp),
                        color = Color(0xFF535353)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_check_24), // 체크 아이콘 리소스 사용
                        contentDescription = null,
                        tint = Color(0xFF00FFA3),
                    )
                    Text(
                        text = "인기순",
                        modifier = Modifier
                            .clickable { selectedText = "인기순" }
                            .padding(8.dp),
                        color = Color(0xFF00FFA3)
                    )
                }
            }


            // 공지사항
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF303032),
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                // 공지사항 1
                NoticeRow(
                    icon = R.drawable.ic_baseline_error_24,
                    title = "첫 번째 공지사항",
                    date = "07-09"
                )
                Divider(color = Color.Gray, thickness = 0.5.dp)
                // 공지사항 2
                NoticeRow(
                    icon = R.drawable.ic_baseline_error_24,
                    title = "두 번째 공지사항",
                    date = "07-08"
                )
                Divider(color = Color.Gray, thickness = 0.5.dp)
                // 공지사항 3
                NoticeRow(
                    icon = R.drawable.ic_baseline_error_24,
                    title = "세 번째 공지사항",
                    date = "07-07"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))


            // 메인 게시물
            PostList(posts = postItems)


            // 플로팅 버튼
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                FloatingActionButton(
                    onClick = {
                        // TODO 플로팅 버튼 클릭 시 동작 추가
                    },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 16.dp),
                    containerColor = Color(0xFF00FFA3)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }
            }


        }
    }

}

// 공지사항
@Composable
fun NoticeRow(
    icon: Int,
    title: String,
    date: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF303032),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(
                top = 8.dp,
                bottom = 8.dp,
                start = 16.dp,
                end = 16.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color(0xFFA4FFDE))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            color = Color.White,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = date,
            color = Color(0xFFADADAD)
        )
    }
}


// 게시물 레이아웃
@Composable
fun PostRow(
    item: PostItem,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF303032),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(
                top = 8.dp,
                bottom = 8.dp,
                start = 16.dp,
                end = 16.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // 제목
                    Text(
                        text = item.title,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    // 댓글 수
                    Text(
                        text = "(${item.commentNum})",
                        color = Color(0xFF00FFA3),
                        fontSize = 14.sp
                    )
                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    // 작성자 이름
                    Text(
                        text = item.name,
                        color = Color(0xFFADADAD),
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    // 작성 날짜
                    Text(
                        text = item.date,
                        color = Color(0xFFADADAD),
                        fontSize = 12.sp
                    )
                }
            }
        }

        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
    Divider(color = Color.Gray, thickness = 0.5.dp)
}

// 게시물 LazyColumn
@Composable
fun PostList(posts: List<PostItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF303032),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        items(posts) { post ->
            PostRow(post)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StreamerScreenPreview() {

    // Test Data
    val previewViewModel = StreamerViewModel().apply {

    }
    val navController = rememberNavController()

    ZiriritTheme {
        StreamerScreen(navController)
    }
}

