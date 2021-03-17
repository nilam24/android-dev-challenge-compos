/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(isSystemInDarkTheme())
            }
        }
    }
}

@Composable
fun MyApp(systemInDarkTheme: Boolean) {
    GetContext()
    if (systemInDarkTheme)
        MyAppDark()
    else MyAppLight()
}

// Start building your app here!
@Composable
fun MyAppDark() {
    Surface(color = MaterialTheme.colors.background) {
        Box {

            Image(
                painter = painterResource(id = R.drawable.ic_dark_welcome_bg),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),

                alignment = Alignment.Center
            )
            Image(
                painter = painterResource(id = R.drawable.ic_dark_welcome_illos),
                contentDescription = null,
                modifier = Modifier
                    .height(359.dp)
                    .width(429.dp)
                    .absolutePadding(88.dp, 72.dp, 0.dp, 48.dp),
                alignment = Alignment.TopEnd,
                contentScale = ContentScale.FillHeight
            )

            Column(
                modifier = Modifier
                    .absolutePadding(16.dp, 360.dp, 0.dp, 48.dp)
                    .fillMaxSize()
            ) {

                Text(
                    text = "Bloom", color = colorResource(R.color.green_300),
                    style = typography.h1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()

                )

                Text(
                    text = "Beautiful home garden solutions",
                    color = colorResource(R.color.green_300),
                    style = typography.subtitle1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),

                    )


                Button(modifier = Modifier
                    .absolutePadding(16.dp, 40.dp, 16.dp, 8.dp)
                    .height(56.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(CornerSize(24.dp)),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.green_300)),
                    onClick = { createAccount() }) {
                    Text(
                        text = "Create Account",
                        color = colorResource(R.color.gray),
                        style = typography.button
                    )
                }
//                   Spacer(modifier = Modifier.padding(30.dp))
//            Text(
//                style = TextStyle(color = colorResource(id = R.color.pink_900)),
//                text = "Log in",
//                modifier = Modifier.absolutePadding(120.dp, 470.dp, 30.dp, 30.dp),
//                color = Color(R.color.pink_900)
//            )

                TextButton(
                    modifier = Modifier
                        .absolutePadding(16.dp, 8.dp, 16.dp, 16.dp)
                        .fillMaxWidth(),
                    onClick = { onLoginSuccess() }
                ) {
                    Text(
                        text = "Log in....",
                        style = typography.button, color = colorResource(id = R.color.green_300)
                    )
                }
            }
        }


    }
}

@Composable
fun MyAppLight() {
    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxSize()
                .background(color = colorResource(id = R.color.pink_100))
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_light_welcome_bg),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxWidth()
                    .padding(8.dp),
                alignment = Alignment.Center
            )
            Image(
                painter = painterResource(id = R.drawable.ic_light_welcome_illos),
                contentDescription = null,
                modifier = Modifier
                    .height(279.dp)
                    .width(369.dp)
                    .absolutePadding(160.dp, 89.dp, 2.dp, 0.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier
                    .absolutePadding(16.dp, 360.dp, 20.dp, 0.dp)
                    .fillMaxWidth()
            ) {


                Text(
                    text = "Bloom",
                    color = colorResource(R.color.pink_900),
                    modifier = Modifier
                        .padding(9.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(color = colorResource(R.color.pink_900), fontSize = 18.sp)
//                    modifier = Modifier.absolutePadding(120.dp, 360.dp, 20.dp, 9.dp)
                )


                Text(
                    text = "Beautiful home garden solutions",
                    color = colorResource(R.color.gray),
                    modifier = Modifier
                        .padding(9.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = typography.subtitle1,

//                    modifier = Modifier.absolutePadding(120.dp, 385.dp, 30.dp, 30.dp)
                )
                Button(modifier = Modifier
                    .absolutePadding(16.dp, 40.dp, 16.dp, 8.dp)
                    .height(56.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(corner = CornerSize(24.dp)),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.pink_900)),
                    onClick = { createAccount() }) {
                    Text(
                        text = "Create Account",
                        color = colorResource(R.color.white),
                        style = typography.button
                    )
                }

                TextButton(
                    modifier = Modifier
                        .absolutePadding(16.dp, 16.dp, 16.dp, 16.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = { onLoginSuccess() }
                ) {
                    Text(
                        text = "Log in....",
                        style = typography.button, color = colorResource(id = R.color.pink_900)
                    )
                }
            }
        }


    }
}

@SuppressLint("StaticFieldLeak")
private var context: Context? = null
var intent: Intent? = null

@Composable
private fun GetContext() {
    context = MyContext.getInstance().getMyAppContext()

}

private fun doLogin() {
    intent = Intent(context, LoginActivity::class.java)
    context?.startActivity(intent)
}

private fun onLoginSuccess() {
    doLogin()
//    intent = Intent(context, HomeActivity::class.java)
//    context?.startActivity(intent)
}

//private fun showError() {
//    Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show()
//}

private fun createAccount() {
    doLogin()
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyAppLight()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyAppDark()
    }
}
