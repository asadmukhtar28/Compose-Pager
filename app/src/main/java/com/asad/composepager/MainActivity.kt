package com.asad.composepager

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asad.composepager.onboarding.horizontal.OnBoardingHorizontalActivity
import com.asad.composepager.onboarding.vertical.OnBoardingVerticalActivity
import com.asad.composepager.ui.theme.ComposePagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePagerTheme {
                MainActivityScreen()
            }
        }
    }
}

@Preview
@Composable
fun MainActivityScreen() {
    val context = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background) {
        Row(modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(onClick = {
                    context.startActivity(Intent(context, OnBoardingHorizontalActivity::class.java))
                }) {
                    Text(text = "Horizontal ViewPager")
                }
                Button(onClick = {
                    context.startActivity(Intent(context, OnBoardingVerticalActivity::class.java))
                }) {
                    Text(text = "Vertical ViewPager")
                }
            }
        }
    }
}



