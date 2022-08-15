package com.basakyardim.sportsbettingapp.di

import com.basakyardim.sportsbettingapp.data.remote.BettingApi
import com.basakyardim.sportsbettingapp.data.repository.BettingRepositoryImpl
import com.basakyardim.sportsbettingapp.domain.repository.BettingRepository
import com.basakyardim.sportsbettingapp.domain.use_case.SportsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSportsUseCase(repository: BettingRepository): SportsListUseCase {
        return SportsListUseCase(repository = repository)
    }

    @Provides
    @Singleton
    fun provideBettingRepository(
        api:BettingApi
    ): BettingRepository {
        return BettingRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideApi(): BettingApi {
        return Retrofit.Builder()
            .baseUrl(BettingApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BettingApi::class.java)
    }
}