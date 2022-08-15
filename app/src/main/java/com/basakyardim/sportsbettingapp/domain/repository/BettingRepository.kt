package com.basakyardim.sportsbettingapp.domain.repository

import com.basakyardim.sportsbettingapp.data.remote.dto.odds.OddsDtoItem
import com.basakyardim.sportsbettingapp.domain.model.SportsItem
import com.basakyardim.sportsbettingapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface BettingRepository {

    fun fetchSports(): Flow<Resource<List<SportsItem>>>

    fun fetchOdds(sport: String, region: String): Flow<Resource<List<OddsDtoItem>>>

}