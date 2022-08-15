package com.basakyardim.sportsbettingapp.presentation.basket_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basakyardim.sportsbettingapp.presentation.odds_screen.CartObj

@Composable
fun BasketScreenItem(
    odds: CartObj,
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

            Text(text = odds.price.toString(),
                textAlign = TextAlign.Center)

        }

    }

}