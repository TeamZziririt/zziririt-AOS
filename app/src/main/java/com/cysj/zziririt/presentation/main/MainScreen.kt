package com.cysj.zziririt.presentation.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.cysj.zziririt.presentation.board.streamer_board.StreamerScreen
import com.cysj.zziririt.presentation.home.HomeScreen
import com.cysj.zziririt.presentation.my_info.MyInfoScreen
import com.cysj.zziririt.presentation.my_info.ProfileSettingScreen
import com.cysj.zziririt.presentation.my_info.SettingScreen
import com.cysj.zziririt.presentation.postcontent.PostContentScreen
import com.cysj.zziririt.presentation.search.SearchScreen
import com.cysj.zziririt.ui.theme.ZziriritTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val items by mainViewModel.items.observeAsState(emptyList())

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, items) }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
        ) {
            NavigationHost(
                navController,
            )
        }
    }
}

// 하단 네비게이션 바 설정
@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<String>,
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.Black
    ) {
        items.forEach { screen ->
            val isSelected = currentDestination?.route == screen
            val iconColor = if (isSelected) Color(0xFF00FFA3) else Color.White

            NavigationBarItem(
                icon = {
                    when (screen) {
                        "home" -> Icon(
                            Icons.Filled.Home,
                            contentDescription = null,
                            tint = iconColor
                        )

                        "board" -> Icon(
                            Icons.Filled.Notifications,
                            contentDescription = null,
                            tint = iconColor
                        )

                        "search" -> Icon(
                            Icons.Filled.Search,
                            contentDescription = null,
                            tint = iconColor
                        )

                        "my_info" -> Icon(
                            Icons.Filled.Person,
                            contentDescription = null,
                            tint = iconColor
                        )
                    }
                },
                label = {
                    when (screen) {
                        "home" -> Text(text = "Home")
                        "board" -> Text(text = "Board")
                        "search" -> Text(text = "Search")
                        "my_info" -> Text(text = "My Info")
                        else -> null
                    }
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Board.route) { StreamerScreen(navController) }
        composable(Screen.Search.route) { SearchScreen(navController) }
        composable(Screen.MyInfo.route) { MyInfoScreen(navController) }
        composable(Screen.PostContent.route) { PostContentScreen(navController) }
        composable(Screen.Setting.route) { SettingScreen(navController) }
        composable(Screen.ProfileSetting.route) { ProfileSettingScreen(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    // 미리보기용으로 ViewModel을 직접 생성
    val previewViewModel = MainViewModel().apply {
        setItems(listOf("home", "board", "search", "my_info"))
    }

    ZziriritTheme {
        val navController = rememberNavController()
        MainScreen(navController, previewViewModel)
    }
}
