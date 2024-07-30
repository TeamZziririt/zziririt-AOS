package com.cysj.zziririt.presentation.my_info

import android.Manifest
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cysj.zziririt.R
import com.cysj.zziririt.ui.theme.ZziriritTheme
import com.cysj.zziririt.ui.theme.gmarketsans_light
import com.cysj.zziririt.ui.theme.gmarketsans_medium


@Composable
fun ProfileSettingScreen(navController: NavController) {
    Box(modifier = Modifier.background(Color.Black)) {
        val context = LocalContext.current

        val permissions = listOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_MEDIA_IMAGES,
        )

        val multiplePermissionsLauncher = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissionsMap ->
            permissionsMap.forEach { (permission, isGranted) ->
                Toast.makeText(context, "$permission isGranted = $isGranted", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(id = R.drawable.ic_back_btn), contentDescription = null,
                        modifier = Modifier.clickable { navController.popBackStack() },
                    )
                    Text(
                        text = "프로필 설정",
                        fontWeight = FontWeight.Bold,
                        fontFamily = gmarketsans_medium,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center
                    )
                }


                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = Color.Gray, thickness = 0.5.dp)
                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painterResource(id = R.drawable.ic_profie_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "사진 변경", color = Color.Blue,
                    fontFamily = gmarketsans_medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 8.dp)
                        .clickable {
                            // 사진변경
                            multiplePermissionsLauncher.launch(permissions.toTypedArray())
                        },
                    textAlign = TextAlign.Center

                )
            } // Column 1

            Column() {
                Text(
                    text = "대니주", color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = gmarketsans_medium,
                )
            } // Column 2
        } //전체 c
    }
}


@Preview
@Composable
fun ProfileSettingScreenPreview() {
    ZziriritTheme {
        val navController = rememberNavController()
        ProfileSettingScreen(navController)
    }

}