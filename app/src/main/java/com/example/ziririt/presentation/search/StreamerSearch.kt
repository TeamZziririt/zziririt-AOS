package com.example.ziririt.presentation.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StreamerSearch() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(all = 8.dp)) {
        Column {
            Text(text = "스트리머 게시판 검색", fontWeight = FontWeight.Bold, color = Color.White)
            SearchBar()

        } // column
    }


}
@Composable
fun SearchBar(
) { // searchbar

    }


@Preview
@Composable
fun StreamerSearchPreview() {
    StreamerSearch()
}