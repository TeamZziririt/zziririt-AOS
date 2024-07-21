package com.cysj.zziririt.presentation.postcontent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostContentViewModel @Inject constructor() : ViewModel() {
    companion object {
        const val TAG = "PostContentViewModel"
    }

    // 임시 댓글 리스트를 LiveData로 관리
    private val _comments = MutableLiveData<List<CommentItem>>(emptyList())
    val comments: LiveData<List<CommentItem>> get() = _comments

    // 임시 댓글 리스트 초기화
    init {
        loadComments()
    }

    // 임시 댓글 리스트를 로드하는 함수
    private fun loadComments() {
        _comments.value = listOf(
            CommentItem("닉네임1", "1시간 전", "댓글 내용1"),
            CommentItem("닉네임2", "2시간 전", "댓글 내용2"),
            CommentItem("닉네임3", "3시간 전", "댓글 내용3")
        )
    }

    fun setComments(comments: List<CommentItem>) {
        _comments.value = comments
    }
}
