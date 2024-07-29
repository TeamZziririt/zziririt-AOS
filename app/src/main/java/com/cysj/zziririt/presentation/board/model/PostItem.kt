package com.cysj.zziririt.presentation.board.model

sealed class PostItem(
    open val id: Int,
    open val title: String,
    open val imageRes: Int,
    open val name: String,
    open val date: String,
) {
    data class BriefPostItem(
        override val id: Int,
        override val title: String,
        override val imageRes: Int,
        override val name: String,
        override val date: String,
        val commentNum: Int,
    ) : PostItem(id, title, imageRes, name, date)

    data class DetailPostItem(
        override val id: Int,
        override val title: String,
        override val imageRes: Int,
        override val name: String,
        override val date: String,
        val commentNum: Int,
        val content: String,
        val imageResList: List<Int>,
        val onFavoriteClick: () -> Unit,
        val onShareClick: () -> Unit,
    ) : PostItem(id, title, imageRes, name, date)

    data class BoardRankingInfoPostItem(
        override val id: Int,
        override val title: String,
        override val imageRes: Int,
        override val name: String,
        override val date: String,
        val rank: Int,
    ) : PostItem(id, title, imageRes, name, date)
}

