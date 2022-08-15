package com.basakyardim.sportsbettingapp.data.remote.dto.odds

data class Market(
    val key: String,
    val outcomes: List<Outcome>
)