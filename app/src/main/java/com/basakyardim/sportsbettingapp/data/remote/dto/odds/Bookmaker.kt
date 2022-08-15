package com.basakyardim.sportsbettingapp.data.remote.dto.odds

data class Bookmaker(
    val key: String,
    val last_update: String,
    val markets: List<Market>,
    val title: String
)