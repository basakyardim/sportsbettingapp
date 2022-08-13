package com.basakyardim.sportsbettingapp.domain.use_case

import com.basakyardim.sportsbettingapp.domain.model.SportsItem
import com.basakyardim.sportsbettingapp.domain.repository.BettingRepository
import com.basakyardim.sportsbettingapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SportsListUseCase @Inject constructor(
    private val repository: BettingRepository
) {
    operator fun invoke(): Flow<Resource<List<SportsItem>>> {

        return repository.fetchSports()
    }
}