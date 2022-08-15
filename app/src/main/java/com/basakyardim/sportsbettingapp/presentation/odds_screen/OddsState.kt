package com.basakyardim.sportsbettingapp.presentation.odds_screen

import com.basakyardim.sportsbettingapp.data.remote.dto.odds.OddsDtoItem

data class OddsState(
    val isLoading: Boolean = false,
    val odds: List<OddsDtoItem> = emptyList(),
    val error: String = ""

)