package com.example.ziririt.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ziririt.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {
    companion object {
        const val TAG = "HomeViewModel"
    }

    // 스트리머 정보 리스트
    private val _streamerInfoItems = MutableStateFlow<List<StreamerInfoItem>>(emptyList())
    val streamerInfoItems: StateFlow<List<StreamerInfoItem>> = _streamerInfoItems

    // 실시간 인기 게시글 정보 리스트
    private val _boardRankingInfoItems = MutableStateFlow<List<BoardRankingInfoItem>>(emptyList())
    val boardRankingInfoItems: StateFlow<List<BoardRankingInfoItem>> = _boardRankingInfoItems


    init {
        // 예시 데이터를 로드
        viewModelScope.launch {
            // TODO Test Data
            _streamerInfoItems.value = listOf(
//                StreamerInfoItem("스트리머1", 1000, true),
//                StreamerInfoItem("스트리머2", 2000, false),
//                StreamerInfoItem("스트리머3", 1500, true),
//                StreamerInfoItem("스트리머4", 2500, false),
//                StreamerInfoItem("스트리머5", 3000, true),
            )

            _boardRankingInfoItems.value = listOf(
                BoardRankingInfoItem(rank = 1, imageRes = R.drawable.img, title = "게시글 제목 1", username = "유저닉네임 1"),
//                BoardRankingInfoItem(rank = 2, imageRes = R.drawable.img, title = "게시글 제목 2", username = "유저닉네임 2"),
//                BoardRankingInfoItem(rank = 3, imageRes = R.drawable.img, title = "게시글 제목 3", username = "유저닉네임 3"),
                BoardRankingInfoItem(rank = 4, imageRes = R.drawable.img, title = "게시글 제목 4", username = "유저닉네임 4"),
                BoardRankingInfoItem(rank = 5, imageRes = R.drawable.img, title = "게시글 제목 5", username = "유저닉네임 5"),
//                BoardRankingInfoItem(rank = 6, imageRes = R.drawable.img, title = "게시글 제목 6", username = "유저닉네임 6"),
                BoardRankingInfoItem(rank = 7, imageRes = R.drawable.img, title = "게시글 제목 7", username = "유저닉네임 7"),
                BoardRankingInfoItem(rank = 8, imageRes = R.drawable.img, title = "게시글 제목 8", username = "유저닉네임 8"),
                BoardRankingInfoItem(rank = 9, imageRes = R.drawable.img, title = "게시글 제목 9", username = "유저닉네임 9"),
                BoardRankingInfoItem(rank = 10, imageRes = R.drawable.img, title = "게시글 제목 10", username = "유저닉네임 10")

            )
        }
    }
}