package com.cysj.zziririt.presentation.my_info.my_zziririt

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun WrittenCommentScreen(navController: NavController) {}


@Preview
@Composable
fun WrittenCommentPreview() {
    val navController = rememberNavController()
    WrittenCommentScreen(navController)
}