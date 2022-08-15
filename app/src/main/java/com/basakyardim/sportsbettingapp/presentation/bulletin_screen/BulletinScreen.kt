package com.basakyardim.sportsbettingapp.presentation.bulletin_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.basakyardim.sportsbettingapp.R
import com.basakyardim.sportsbettingapp.domain.model.SportsItem
import com.basakyardim.sportsbettingapp.presentation.destinations.OddsScreenDestination
import com.basakyardim.sportsbettingapp.presentation.ui.theme.Blue
import com.basakyardim.sportsbettingapp.util.SearchView
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun BulletinScreen(
    navigator: DestinationsNavigator,
    viewModel: BulletinViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val searchedText = textState.value.text
    var filteredList = ArrayList<SportsItem>()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 50.dp)

    ) {

        SearchView(state = textState)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
        ) {
            state.sports.forEach{
                if(it.title.contains(searchedText, ignoreCase = true)
                    || it.description.contains(searchedText, ignoreCase = true)){
                    filteredList.add(it)
                }
            }

            items(filteredList.size) { i ->
                val sport = filteredList[i]
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

