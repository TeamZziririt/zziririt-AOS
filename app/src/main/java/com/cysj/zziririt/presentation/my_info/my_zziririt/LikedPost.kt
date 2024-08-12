package com.cysj.zziririt.presentation.my_info.my_zziririt

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LikedPostScreen(navController: NavController) {}


@Preview
@Composable
fun LikedPostPreview() {
    val navController = rememberNavController()
    LikedPostScreen(navController)
}