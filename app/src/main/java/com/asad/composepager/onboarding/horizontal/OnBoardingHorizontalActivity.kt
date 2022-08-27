package com.asad.composepager.onboarding.horizontal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.asad.composepager.R
import com.asad.composepager.ui.theme.ComposePagerTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class OnBoardingHorizontalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePagerTheme {
                OnBoardingScreenDesign()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class, ExperimentalUnitApi::class)
@Preview
@Composable
fun OnBoardingScreenDesign() {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(count = 3, modifier = Modifier
            .weight(0.9f, true),
            state = pagerState) { page ->
            when (page) {
                0 -> PageItem(imageResourceId = R.drawable.ic_search, title = "CHOOSE YOUR MEAL")
                1 -> PageItem(imageResourceId = R.drawable.ic_choose_payment,
                    title = "CHOOSE YOUR PAYMENT")
                2 -> PageItem(imageResourceId = R.drawable.ic_fast_delivery,
                    title = "FAST DELIVERY")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(0.1f, true)
            .background(color = Color.White)
            .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            HorizontalPagerIndicator(pagerState = pagerState,
                activeColor = Color(0xFF00F7FF),
                inactiveColor = Color(0xFFAFB2B3))

            Text(text = "Next",
                modifier = Modifier.clickable {
                    if (pagerState.currentPage < 3) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
                style = TextStyle(color = Color(0xFF5959A1),
                    fontSize = TextUnit(16f, TextUnitType.Sp),
                    fontFamily = FontFamily.Monospace))
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun PageItem(
    @DrawableRes imageResourceId: Int,
    title: String, subTitle: Int = R.string.dummy_text,
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        Image(painter = painterResource(id = imageResourceId), contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(250.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = title,
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color(0xFF5959A1),
                    fontSize = TextUnit(16f, TextUnitType.Sp),
                    fontFamily = FontFamily.Monospace))

            Text(text = stringResource(subTitle),
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color(0xFF26DAC9)),
                fontSize = TextUnit(14f, TextUnitType.Sp))
        }
    }
}