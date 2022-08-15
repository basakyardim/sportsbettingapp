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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun OddsScreenItem(
    odds: OddsDtoItem,
    modifier: Modifier
) {

    val database = Firebase.database
    val uid = FirebaseAuth.getInstance().currentUser?.uid
    val myRef = database.reference

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
                if (odds.bookmakers[0].markets[0].outcomes.size == 2) {
                    Column(modifier = Modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "1")
                        Button(onClick = {
                            if (uid != null) {
                                addOddToCart(odds.home_team, odds.away_team,odds.bookmakers[0].markets[0].outcomes[0].price, myRef,uid)
                            }
                                         },
                            colors = ButtonDefaults.buttonColors(Blue)) {
                            Text(text = odds.bookmakers[0].markets[0].outcomes[0].price.toString(),
                                textAlign = TextAlign.Center)
                        }
                    }
                   Column(modifier = Modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally) {
                       Text(text = "2")
                       Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Blue)) {
                           Text(text = odds.bookmakers[0].markets[0].outcomes[1].price.toString(),
                               textAlign = TextAlign.Center)
                       }
                   }
                  
                }
                else if (odds.bookmakers[0].markets[0].outcomes.size == 3) {
                    Column(modifier = Modifier.fillMaxHeight(),horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "1")
                        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Blue)) {
                            Text(text = odds.bookmakers[0].markets[0].outcomes[0].price.toString(),
                                textAlign = TextAlign.Center)
                        }
                    }
                  
                    Column(modifier = Modifier.fillMaxHeight(),horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "0")
                        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Blue)) {
                            Text(text = odds.bookmakers[0].markets[0].outcomes[2].price.toString(),
                                textAlign = TextAlign.Center)
                        }
                    }
                    
                    Column(modifier = Modifier.fillMaxHeight(),horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "2")
                        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Blue)) {
                            Text(text = odds.bookmakers[0].markets[0].outcomes[1].price.toString(),
                                textAlign = TextAlign.Center)
                        }
                    }
                    


                }




            }



        }
        
    }

}

private fun addOddToCart(homeTeam:String, awayTeam:String, price:Double, ref:DatabaseReference, userId: String){
    val cartObj = CartObj(home_team = homeTeam, away_team = awayTeam, price = price)
    val cartRef = ref.child("users").child(userId).push()
    cartRef.setValue(cartObj)
    }


