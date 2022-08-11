package com.basakyardim.sportsbettingapp.data.remote

import com.basakyardim.sportsbettingapp.BuildConfig
import com.basakyardim.sportsbettingapp.data.remote.dto.sports.SportsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BettingApi {

    @GET("/v4/sports")
    suspend fun getSports(
        @Query("apiKey") apiKey: String = API_KEY
    ): SportsDto

    companion object {

        val API_KEY = BuildConfig.API_KEY
        val BASE_URL = "https://api.the-odds-api.com"

    }

}