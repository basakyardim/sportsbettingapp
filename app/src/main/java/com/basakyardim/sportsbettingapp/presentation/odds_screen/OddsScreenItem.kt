package com.basakyardim.sportsbettingapp.presentation.odds_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basakyardim.sportsbettingapp.data.remote.dto.odds.OddsDtoItem
import com.basakyardim.sportsbettingapp.presentation.ui.theme.Blue

@Composable
fun OddsScreenItem(
    odds: OddsDtoItem,
    modifier: Modifier
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = 5.dp
       
    ) {
        Column(modifier = modifier.fillMaxSize()) {

            Row(
                modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
                ) {
                Text(text = odds.home_team + " - " + odds.away_team, fontSize = 14.sp, fontWeight = FontWeight.Bold)

            }
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Blue)) {
                    Text(text = odds.bookmakers[0].markets[0].outcomes[0].price.toString(),
                        textAlign = TextAlign.Center)
                }
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Blue)) {
                    Text(text = odds.bookmakers[0].markets[0].outcomes[1].price.toString(),
                        textAlign = TextAlign.Center)
                }



            }



        }
        
    }

}

