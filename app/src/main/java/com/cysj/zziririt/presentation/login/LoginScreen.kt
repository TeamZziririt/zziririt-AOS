@file:JvmName("LoginScreenKt")

package com.cysj.zziririt.presentation.login

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.cysj.zziririt.R
import com.cysj.zziririt.domain.usecase.OAuthLoginUseCase
import com.cysj.zziririt.presentation.board.streamer_board.StreamerBoardViewModel
import com.cysj.zziririt.presentation.login.model.AuthState
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback
import com.navercorp.nid.oauth.view.NidOAuthLoginButton

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val authState by viewModel.authState.collectAsState()


    when (authState) {
        is AuthState.Success -> {
            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
        }
        is AuthState.Failure -> {
            val errorState = authState as AuthState.Failure
            Toast.makeText(
                context,
                "errorCode: ${errorState.errorCode}, errorDesc: ${errorState.errorDescription}",
                Toast.LENGTH_SHORT
            ).show()
        }
        else -> {
            // Idle 상태일 때 UI 업데이트
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141517)),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = {
                        (context as? Activity)?.finish()
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                        contentDescription = "Back Button",
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // 화면
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painterResource(
                        id = R.drawable.ic_zziririt_logo
                    ),
                    contentDescription = "Zziririt Image"
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "로그인하고 찌리릿 서비스를\n자유롭게 사용해보세요",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(32.dp))


                /*
                * 네이버 로그인 버튼
                Box(
                    modifier = Modifier
                        .background(
                            Color(0xFF2DB400),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable {
                            // TODO: 버튼 클릭 시 동작
                        }
                        .fillMaxWidth() // 너비를 최대한으로 설정
                        .padding(
                            4.dp
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth() // 너비를 최대한으로 설정
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.naver_logo),
                            contentDescription = "Naver_logo",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "네이버 로그인",
                            color = Color.White,
                            fontSize = 16.sp,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                * */

                /*
                * 네이버 로그인 버튼 */
                AndroidView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    factory = { ctx ->
                        NidOAuthLoginButton(ctx).apply {
                            setOnClickListener {
                                viewModel.authenticate(context)
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))

                /*
                * 카카오 로그인 버튼*/
                Box(
                    modifier = Modifier
                        .background(
                            Color(0xFFFEE500),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable {
                            // TODO: 버튼 클릭 시 동작
                        }
                        .fillMaxWidth() // 너비를 최대한으로 설정
                        .padding(4.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth() // 너비를 최대한으로 설정
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.kakaotalk_logo),
                            contentDescription = "kakaotalk_logo",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "카카오 로그인",
                            color = Color.White,
                            fontSize = 16.sp,
                        )
                    }
                }

            }
        }
    }

}

@Preview
@Composable
fun LoginScreensPreview() {

    val previewViewModel = LoginViewModel.apply {

    }

    LoginScreen()
}