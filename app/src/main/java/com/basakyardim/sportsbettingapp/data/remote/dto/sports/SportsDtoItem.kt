package com.basakyardim.sportsbettingapp.data.remote.dto.sports

import com.basakyardim.sportsbettingapp.domain.model.SportsItem

data class SportsDtoItem(
    val active: Boolean,
    val description: String,
    val group: String,
    val has_outrights: Boolean,
    val key: String,
    val title: String
) {

    fun toSportsItem(): SportsItem {
        return SportsItem(
            description = description,
            group = group,
            key = key,
            title = title
        )
    }
}