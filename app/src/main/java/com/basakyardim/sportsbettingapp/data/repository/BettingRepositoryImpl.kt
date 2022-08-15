package com.basakyardim.sportsbettingapp.data.repository

import com.basakyardim.sportsbettingapp.data.remote.BettingApi
import com.basakyardim.sportsbettingapp.data.remote.dto.odds.OddsDtoItem
import com.basakyardim.sportsbettingapp.domain.model.SportsItem
import com.basakyardim.sportsbettingapp.domain.repository.BettingRepository
import com.basakyardim.sportsbettingapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class BettingRepositoryImpl @Inject constructor(
    private val api: BettingApi
) : BettingRepository{

    override fun fetchSports(): Flow<Resource<List<SportsItem>>> = flow {
        emit(Resource.Loading())

        try {
            val sports = api.getSports().map { it.toSportsItem() }
            emit(Resource.Success(sports))

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",

                )
            )

        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Could not reach the server, check your internet connection!"
            ))

        }


    }

    override fun fetchOdds(sport: String, region: String): Flow<Resource<List<OddsDtoItem>>> = flow {
        emit(Resource.Loading())
        try {
            val odds = api.getOdds(sport,region)
            emit(Resource.Success(odds))

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",

                    )
            )

        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Could not reach the server, check your internet connection!"
            ))

        }
    }
}