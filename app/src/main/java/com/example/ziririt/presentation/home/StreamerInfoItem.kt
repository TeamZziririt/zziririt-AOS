package com.example.ziririt.presentation.home

data class StreamerInfoItem(
    val name: String,
    val subscribers: Int,
    val isFollow: Boolean,
)

data class BoardRankingInfoItem(
    val rank: Int,
    val imageRes: Int,
    val title: String,
    val username: String,
)