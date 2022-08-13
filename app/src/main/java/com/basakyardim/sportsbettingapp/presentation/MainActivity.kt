package com.basakyardim.sportsbettingapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.*
import com.basakyardim.sportsbettingapp.presentation.ui.theme.SportsBettingAppTheme
import com.basakyardim.sportsbettingapp.util.BottomBar
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportsBettingAppTheme {
                SplashAnimationLoader()
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomBar(navController = navController)
                    }) {
                    DestinationsNavHost(
                        navGraph = NavGraphs.root,
                        navController = navController
                    )

                }

            }
        }
    }
}


@Composable
fun SplashAnimationLoader() {
    val compositionResult: LottieCompositionResult = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(com.basakyardim.sportsbettingapp.R.raw.animation_splash)
    )

    val progress by animateLottieCompositionAsState(
        composition = compositionResult.value,
        isPlaying = true,
        iterations = 1,
        speed = 1.0f
    )

    LottieAnimation(composition = compositionResult.value, progress = progress)
}