package com.basakyardim.sportsbettingapp.data.remote.dto.odds

data class OddsDtoItem(
    val away_team: String,
    val bookmakers: List<Bookmaker>,
    val commence_time: String,
    val home_team: String,
    val id: String,
    val sport_key: String,
    val sport_title: String
)