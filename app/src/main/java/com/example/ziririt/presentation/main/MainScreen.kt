package com.example.ziririt.presentation.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.ziririt.presentation.board.BoardScreen
import com.example.ziririt.presentation.home.HomeScreen
import com.example.ziririt.presentation.my_info.MyInfoScreen
import com.example.ziririt.presentation.search.SearchScreen
import com.example.ziririt.ui.theme.ZiriritTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()) {
    val navController = rememberNavController()
    val items by mainViewModel.items.observeAsState(emptyList())

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, items) }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
        ) {
            NavigationHost(navController, items)
        }
    }
}

// 하단 네비게이션 바 설정
@Composable
fun BottomNavigationBar(navController: NavHostController, items: List<String>) {
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
                    indicatorColor = Color.Transparent // 선택된 상태의 배경색을 투명하게 설정
                )
            )
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController, items: List<String>) {
    NavHost(navController, startDestination = items.getOrNull(0) ?: "home") {
        composable("home") { HomeScreen() }
        composable("board") { BoardScreen() }
        composable("search") { SearchScreen() }
        composable("my_info") { MyInfoScreen() }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    // 미리보기용으로 ViewModel을 직접 생성
    val previewViewModel = MainViewModel().apply {
        setItems(listOf("home", "board", "search", "my_info"))
    }

    ZiriritTheme {
        MainScreen(previewViewModel)
    }
}
