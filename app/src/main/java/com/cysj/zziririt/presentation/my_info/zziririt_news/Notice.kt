package com.cysj.zziririt.presentation.my_info.zziririt_news

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun NoticeScreen(navController: NavController) {}


@Preview
@Composable
fun NoticePreview() {
    val navController = rememberNavController()
    NoticeScreen(navController)
}