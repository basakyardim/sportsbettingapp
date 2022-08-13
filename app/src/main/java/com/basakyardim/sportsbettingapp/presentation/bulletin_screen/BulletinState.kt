package com.basakyardim.sportsbettingapp.presentation.bulletin_screen

import com.basakyardim.sportsbettingapp.domain.model.SportsItem

data class BulletinState(
    val isLoading: Boolean = false,
    val sports: List<SportsItem> = emptyList(),
    val error: String = ""

)