package com.cysj.zziririt.presentation.board.streamer_board

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cysj.zziririt.R
import com.cysj.zziririt.presentation.board.model.PostItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StreamerBoardViewModel @Inject constructor() : ViewModel() {

    companion object {
        const val TAG = "HomeViewModel"
    }

    val postItems = listOf(
        PostItem.BriefPostItem(
            id = 0,
            imageRes = R.drawable.img,
            title = "게시글 제목1",
            commentNum = 5,
            name = "작성자 이름",
            date = "2023-07-09",
        ),
        PostItem.BriefPostItem(
            id = 1,
            imageRes = R.drawable.img,
            title = "게시글 제목2",
            commentNum = 2,
            name = "작성자 이름",
            date = "2023-07-10",
        ),
        PostItem.BriefPostItem(
            id = 2,
            imageRes = R.drawable.img,
            title = "게시글 제목3",
            commentNum = 4,
            name = "훈이좋아",
            date = "2023-07-11",
        ),
    )

    private val _items = MutableLiveData<List<PostItem>>()
    val items: LiveData<List<PostItem>> get() = _items

    private val _selectedPost = MutableLiveData<PostItem?>()
    val selectedPost: LiveData<PostItem?> = _selectedPost

    private val _searchText = MutableLiveData("")
    val searchText: LiveData<String> get() = _searchText

    fun setItems(items: List<PostItem>) {
        _items.value = items
    }

    fun selectPost(post: PostItem) {
        _selectedPost.value = post
    }

    fun setSearchText(text: String) {
        _searchText.value = text
    }
}
