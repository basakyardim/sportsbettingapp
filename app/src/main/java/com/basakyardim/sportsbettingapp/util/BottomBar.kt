package com.basakyardim.sportsbettingapp.util

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.get
import com.basakyardim.sportsbettingapp.presentation.destinations.BulletinScreenDestination
import com.basakyardim.sportsbettingapp.presentation.navDestination
import com.basakyardim.sportsbettingapp.presentation.ui.theme.Blue
import com.ramcosta.composedestinations.navigation.navigateTo

@ExperimentalAnimationApi
@Composable
fun BottomBar(
    navController: NavController
) {

    val currentDestination = navController.currentBackStackEntryAsState().value?.navDestination

    BottomNavigation(
        modifier = Modifier.graphicsLayer {
            shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp
            )
            clip = true
        },
        backgroundColor = Blue
    ) {
        BottomBarDestinations.values().forEach { destination ->

            BottomNavigationItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigateTo(destination.direction) {
                        popUpTo(navController.graph[BulletinScreenDestination.route].id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            icon = {
                NavigationItemIcon(
                    destination = destination,
                    selected = currentDestination == destination.direction
                )
            },
            unselectedContentColor = Color.White,
            selectedContentColor = Blue)
        }


    }
}

@ExperimentalAnimationApi
@Composable
private fun NavigationItemIcon(destination: BottomBarDestinations, selected: Boolean) {
    AnimatedContent(targetState = selected) { target ->
        if (target) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        Color.White, RoundedCornerShape(
                            topStart = 10.dp,
                            topEnd = 10.dp,
                            bottomEnd = 20.dp,
                            bottomStart = 20.dp
                        )
                    )
                    .padding(bottom = 6.dp)

            ) {
                Icon(
                    painter = painterResource(id = destination.icon),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(23.dp, 23.dp)
                )

            }
        } else {
            Box(
                modifier = Modifier
                    .size(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = destination.icon),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(23.dp, 23.dp)
                )

            }
        }
    }

}
