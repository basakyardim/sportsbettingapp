package com.basakyardim.sportsbettingapp.util

import com.basakyardim.sportsbettingapp.R
import com.basakyardim.sportsbettingapp.presentation.destinations.BasketScreenDestination
import com.basakyardim.sportsbettingapp.presentation.destinations.BulletinScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class BottomBarDestinations(
    val direction: DirectionDestinationSpec,
    val icon: Int,
    val label: String
) {

    Bulletin(BulletinScreenDestination, R.drawable.bulletin_icon, "Bulletin"),
    Basket(BasketScreenDestination, R.drawable.bet, "Basket"),

}