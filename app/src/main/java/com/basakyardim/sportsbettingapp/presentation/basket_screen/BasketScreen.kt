package com.basakyardim.sportsbettingapp.presentation.basket_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.basakyardim.sportsbettingapp.presentation.odds_screen.CartObj
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun BasketScreen(){

    var listOfOdds = ArrayList<CartObj>()
    getAddedOddsFromFirebase(listOfOdds)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {

        items(listOfOdds.size) { i ->
            val odds = listOfOdds[i]
            BasketScreenItem(odds = odds, modifier = Modifier)

            if (i < listOfOdds.size) {
                Divider(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )
            }
        }

    }

}

private fun getAddedOddsFromFirebase(list: ArrayList<CartObj>){
    val uid = FirebaseAuth.getInstance().currentUser?.uid.toString()
    val myRef = FirebaseDatabase.getInstance().reference.child("users").child(uid)

    myRef.addListenerForSingleValueEvent(object : ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            snapshot.children.forEach {
                list.add(it.value as CartObj)
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }

    })

}