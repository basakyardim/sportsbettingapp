package com.basakyardim.sportsbettingapp.domain.use_case

import com.basakyardim.sportsbettingapp.data.remote.dto.odds.OddsDtoItem
import com.basakyardim.sportsbettingapp.domain.repository.BettingRepository
import com.basakyardim.sportsbettingapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OddsUseCase @Inject constructor(
    private val repository: BettingRepository
) {

    operator fun invoke(sport: String, region: String): Flow<Resource<List<OddsDtoItem>>> {

        return repository.fetchOdds(sport = sport, region = region)
    }
}