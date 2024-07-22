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
            CommentItem("닉네임1", "1시간 전", "의존성 주입 프레임워크의 궁극적인 목표\n" +
                    "정확한 사용방법을 제안\n" +
                    "쉬운 설정 방법\n" +
                    "중요한 것들에 집중할 수 있도록 함\n" +
                    "프로젝트 빌드를 시작한 뒤에 사소한 문제로 인해 컴파일 에러 발생\n" +
                    "→ 장점이자 단점, 너무 빈번해지면 개발자의 생산성을 저하시키는 요소가 된다."),
            CommentItem("닉네임2", "2시간 전", "댓글 내용2"),
            CommentItem("닉네임3", "3시간 전", "댓글 내용3"),
            CommentItem("닉네임4", "7시간 전", "댓글 내용4"),
            CommentItem("닉네임5", "7시간 전", "댓글 내용5"),
        )
    }

    fun setComments(comments: List<CommentItem>) {
        _comments.value = comments
    }
}
