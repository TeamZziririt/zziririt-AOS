package com.cysj.zziririt.presentation.my_info.zziririt_news

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun IconShopScreen(navController: NavController) {}


@Preview
@Composable
fun IconShopPreview() {
    val navController = rememberNavController()
    IconShopScreen(navController)
}