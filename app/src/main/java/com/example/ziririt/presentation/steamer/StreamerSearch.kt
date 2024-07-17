package com.example.ziririt.presentation.steamer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ziririt.R
import com.google.android.material.search.SearchBar

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