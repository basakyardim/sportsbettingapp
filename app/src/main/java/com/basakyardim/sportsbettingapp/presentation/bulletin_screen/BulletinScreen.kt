package com.basakyardim.sportsbettingapp.presentation.bulletin_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.basakyardim.sportsbettingapp.R
import com.basakyardim.sportsbettingapp.presentation.destinations.OddsScreenDestination
import com.basakyardim.sportsbettingapp.presentation.ui.theme.Blue
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun BulletinScreen(
    navigator: DestinationsNavigator,
    viewModel: BulletinViewModel = hiltViewModel()
) {

    val listOfImages = listOf(
        R.drawable.american_football_aussie_rules,
        R.drawable.baseball,
        R.drawable.basketball,
        R.drawable.cricket,
        R.drawable.golf,
        R.drawable.ice_hockey,
        R.drawable.soccer,
        R.drawable.tennis,
        R.drawable.others
    )

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 50.dp)

    ) {
        LazyRow {
            itemsIndexed(listOfImages) { index, item ->
                Card(
                    modifier = Modifier
                        .width(80.dp)
                        .height(60.dp)
                        .padding(8.dp)
                        .shadow(3.dp)
                        .clickable {

                        }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(painterResource(
                            id = listOfImages[index]),
                            contentDescription = "Sections",
                            contentScale = ContentScale.Inside
                        )

                    }

                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
        ) {
            items(state.sports.size) { i ->
                val sport = state.sports[i]
                ListItem(sport = sport, modifier = Modifier.clickable {
                    navigator.navigate(OddsScreenDestination(sport.key))
                })

                if (i < state.sports.size) {
                    Divider(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                    )
                }

            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Blue
            )
        }

    }


}

