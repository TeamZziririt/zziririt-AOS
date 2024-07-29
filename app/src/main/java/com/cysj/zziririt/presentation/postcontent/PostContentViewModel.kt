package com.cysj.zziririt.presentation.postcontent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cysj.zziririt.R
import com.cysj.zziririt.presentation.board.model.PostItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostContentViewModel @Inject constructor() : ViewModel() {
    companion object {
        const val TAG = "PostContentViewModel"
    }

    // 임시 게시물 관리
    private val _postItem = MutableLiveData<PostItem.DetailPostItem>()
    val postItem: LiveData<PostItem.DetailPostItem> get() = _postItem

    // 임시 댓글 리스트를 LiveData로 관리
    private val _comments = MutableLiveData<List<CommentItem>>(emptyList())
    val comments: LiveData<List<CommentItem>> get() = _comments


    // 임시 댓글 리스트 초기화
    init {
        testData()
    }

    // 임시 댓글 리스트를 로드하는 함수
    private fun testData() {
        _postItem.value = PostItem.DetailPostItem(
            id = 1,
            title = "게시글 제목1",
            imageRes = R.drawable.img,
            name = "작성자 이름",
            commentNum = 5,
            date = "2023-07-09",
            content = "이곳에 게시글 본문 내용이 들어갑니다. 여러 줄의 텍스트가 포함될 수 있습니다.",
            imageResList = listOf(R.drawable.ic_launcher_foreground), // 예시 이미지 리스트
            onFavoriteClick = { /* TODO: 아이콘 1 클릭 동작 */ },
            onShareClick = { /* TODO: 아이콘 2 클릭 동작 */ }
        )
        _comments.value = listOf(
            CommentItem(
                "닉네임1", "1시간 전", "의존성 주입 프레임워크의 궁극적인 목표\n" +
                        "정확한 사용방법을 제안\n" +
                        "쉬운 설정 방법\n" +
                        "중요한 것들에 집중할 수 있도록 함\n" +
                        "프로젝트 빌드를 시작한 뒤에 사소한 문제로 인해 컴파일 에러 발생\n" +
                        "→ 장점이자 단점, 너무 빈번해지면 개발자의 생산성을 저하시키는 요소가 된다."
            ),
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
