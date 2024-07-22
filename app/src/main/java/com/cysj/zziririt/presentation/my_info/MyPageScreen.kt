package com.cysj.zziririt.presentation.my_info

//enum class MyPageScreen(val route : String) {
//    MyInfoScreen("my_info_screen"),
//    MyPage_Setting("mypage_setting"),
//    MyPage_WrittenPosts("mypage_writtenposts"),
//    MyPage_WrttenComments("mypage_writtencomments"),
//    MyPage_likedPosts("mypage_likedposts"),
//    MyPage_likedComments("mypage_likedcomments")
//}

sealed class MyPageScreen(val route: String) {
    object MyInfo : MyPageScreen("my_info_screen")
    object MyPage_Setting : MyPageScreen("mypage_setting")
    object MyPage_WrittenPosts : MyPageScreen("mypage_writtenposts")
    object MyPage_WrittenComments : MyPageScreen("mypage_writtencomments")
    object MyPage_likedPosts : MyPageScreen("mypage_likedposts")
    object MyPage_likedComments : MyPageScreen("mypage_likedcomments")


}