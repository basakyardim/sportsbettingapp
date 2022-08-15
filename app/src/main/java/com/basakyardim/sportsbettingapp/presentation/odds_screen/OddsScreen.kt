package com.basakyardim.sportsbettingapp.presentation.odds_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
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
import com.basakyardim.sportsbettingapp.data.remote.dto.odds.OddsDtoItem
import com.basakyardim.sportsbettingapp.presentation.ui.theme.Blue
import com.basakyardim.sportsbettingapp.util.SearchView
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun OddsScreen(
    key: String,
    viewModel: OddsViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val searchedText = textState.value.text
    var filteredList = ArrayList<OddsDtoItem>()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)

    ) {
        SearchView(
            state = textState
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
        ) {
            state.odds.forEach{
                if(it.home_team.contains(searchedText, ignoreCase = true)
                    || it.away_team.contains(searchedText, ignoreCase = true)){
                    filteredList.add(it)
                }
            }

            items(filteredList.size) { i ->
                val odds = filteredList[i]
                OddsScreenItem(odds = odds, modifier = Modifier)

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
