package com.basakyardim.sportsbettingapp.data.remote.dto.sports

data class SportsDtoItem(
    val active: Boolean,
    val description: String,
    val group: String,
    val has_outrights: Boolean,
    val key: String,
    val title: String
)