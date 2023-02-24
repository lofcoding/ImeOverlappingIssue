package com.example.androidwindowinsets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidwindowinsets.ui.theme.AndroidWindowInsetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidWindowInsetsTheme {
                val imeState = rememberImeState()
                val scrollState = rememberScrollState()

                LaunchedEffect(key1 = imeState.value) {
                    if (imeState.value){
                        scrollState.animateScrollTo(scrollState.maxValue, tween(300))
                    }
                }

                Box(modifier = Modifier.fillMaxSize()) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState),
                        horizontalAlignment = CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Box(
                            modifier = Modifier
                                .height(100.dp)
                                .fillMaxWidth()
                                .background(Color.Green)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.android_logo),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        TextField(
                            value = "",
                            onValueChange = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            label = {
                                Text(text = "Email")
                            }
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        TextField(
                            value = "",
                            onValueChange = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            label = {
                                Text(text = "Password")
                            }
                        )

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(text = "Login")
                        }
                    }

                }
            }
        }
    }
}
