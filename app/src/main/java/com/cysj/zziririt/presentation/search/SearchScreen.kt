package com.cysj.zziririt.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cysj.zziririt.R
import com.cysj.zziririt.presentation.main.Screen
import com.cysj.zziririt.ui.theme.Zziririt
import com.cysj.zziririt.ui.theme.ZziriritTheme
import com.cysj.zziririt.ui.theme.gmarketsans_bold
import com.cysj.zziririt.ui.theme.gmarketsans_light
import com.cysj.zziririt.ui.theme.gmarketsans_medium

@Composable
fun SearchScreen(
    navController: NavController,
) {
    Box(modifier = Modifier)
    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(8.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "스트리머 게시판 검색",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontFamily = gmarketsans_bold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(top = 15.dp)
                )
                Spacer(modifier = Modifier.width(15.dp))
                SearchBar("")

                SearchBar("안녕하세요")
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "스트리머 게시판 랭킹",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontFamily = gmarketsans_medium,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(5.dp)
                )
                StreamerApplyBtn(navController)
            } // column
        } // box
    }
}

@Composable
private fun SearchBar(
    hint: String,
    modifier: Modifier = Modifier,
    isEnabled: (Boolean) = true,
    height: Dp = 40.dp,
    elevation: Dp = 3.dp,
    backgroundColor: Color = Color.DarkGray,
    cornerShape: Shape = RoundedCornerShape(8.dp),
    onSearchClicked: () -> Unit = {},
    onTextChange: (String) -> Unit = {},
) {

    var text by remember { mutableStateOf(TextFieldValue()) }
    Row(
        Modifier
            .padding(8.dp)
            .height(height)
            .fillMaxWidth()
            .shadow(elevation = elevation, shape = cornerShape)
            .background(color = backgroundColor, shape = cornerShape)
            .clickable { onSearchClicked },
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            modifier = modifier
                .weight(5f)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            value = text,
            onValueChange = {
                text = it
                onTextChange(it.text)
            },
            enabled = isEnabled,
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = gmarketsans_medium,
            ),
            decorationBox = { innerTextField ->
                if (text.text.isEmpty()) {
                    Text(
                        text = "입 력 해",
                        color = Color.LightGray,
                        fontSize = 16.sp,
                        fontFamily = gmarketsans_light
                    )
                }
                innerTextField()
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search,
                showKeyboardOnFocus = true,
            ),
            keyboardActions = KeyboardActions(onSearch = { onSearchClicked() }),
            singleLine = true
        )
        Box(
            modifier = modifier
                .weight(1f)
                .size(40.dp)
                .background(color = Color.Transparent, shape = CircleShape)
                .clickable {
                    if (text.text.isNotEmpty()) {
                        text = TextFieldValue(text = "")
                        onTextChange("")
                    }
                },
        ) {
            if (text.text.isNotEmpty()) {
                Icon(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    painter = painterResource(id = R.drawable.ic_streamer_search),
                    contentDescription = null,
                    tint = Zziririt,
                )
            } else {
                Icon(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    painter = painterResource(id = R.drawable.ic_streamer_search),
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        }
    }
}
    @Composable
    fun StreamerApplyBtn(navController : NavController) {
        Row(
            Modifier
                .heightIn(min = 2.dp)
                .background(Zziririt)
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    navController.navigate(Screen.StreamerBoardApply.route)
                },
        ) {
            Image(
                painterResource(id = R.drawable.ic_streamer_apply_pencil),
                contentDescription = null
            )
            Text(text = "스트리머 게시판 신청하기", fontFamily = gmarketsans_medium, color = Color.Black,)
        }
    }



@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    val navController = rememberNavController()
    ZziriritTheme {
        SearchScreen(navController)
    }
}

