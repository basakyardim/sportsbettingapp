package com.basakyardim.sportsbettingapp.presentation.bulletin_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.basakyardim.sportsbettingapp.domain.model.SportsItem


@Composable
fun ListItem(
    sport: SportsItem,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(90.dp)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = modifier.weight(1f)
        ) {

            Text(
                text = sport.title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Text(
                text = sport.description,
                style = MaterialTheme.typography.body2,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )


        }


    }
}




