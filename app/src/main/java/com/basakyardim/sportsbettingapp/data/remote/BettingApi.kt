package com.basakyardim.sportsbettingapp.data.remote

import com.basakyardim.sportsbettingapp.BuildConfig
import com.basakyardim.sportsbettingapp.data.remote.dto.odds.OddsDtoItem
import com.basakyardim.sportsbettingapp.data.remote.dto.sports.SportsDtoItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BettingApi {

    @GET("/v4/sports")
    suspend fun getSports(
        @Query("apiKey") apiKey: String = API_KEY
    ): List<SportsDtoItem>

    @GET("/v4/sports/{sport}/odds")
    suspend fun getOdds(
        @Path("sport") sport: String,
        @Query("regions") regions: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): List<OddsDtoItem>

    companion object {

        val API_KEY = BuildConfig.API_KEY
        val BASE_URL = "https://api.the-odds-api.com"

    }

}

