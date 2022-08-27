package com.asad.composepager.onboarding.vertical

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asad.composepager.R
import com.asad.composepager.onboarding.horizontal.PageItem
import com.asad.composepager.ui.theme.ComposePagerTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.VerticalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

class OnBoardingVerticalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePagerTheme {
                OnBoardingScreenDesign()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun OnBoardingScreenDesign() {
    val pagerState = rememberPagerState()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        VerticalPager(count = 3, modifier = Modifier.align(Alignment.Center),
            state = pagerState) { page ->
            when (page) {
                0 -> PageItem(imageResourceId = R.drawable.ic_search, title = "CHOOSE YOUR MEAL")
                1 -> PageItem(imageResourceId = R.drawable.ic_choose_payment,
                    title = "CHOOSE YOUR PAYMENT")
                2 -> PageItem(imageResourceId = R.drawable.ic_fast_delivery,
                    title = "FAST DELIVERY")
            }
        }

        Box(modifier = Modifier
            .fillMaxHeight()
            .align(Alignment.CenterEnd)
            .padding(end = 20.dp),
            contentAlignment = Alignment.Center) {
            VerticalPagerIndicator(pagerState = pagerState,
                activeColor = Color(0xFF00F7FF),
                inactiveColor = Color(0xFFAFB2B3))
        }
    }
}
