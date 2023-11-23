package com.nori.quranapp.network.di

import com.nori.quranapp.network.ApiConfig
import com.nori.quranapp.network.RemoteDataSource
import com.nori.quranapp.network.adzan.AdzanApiService
import com.nori.quranapp.network.quran.QuranRepository

object Injection {
    fun provideQuranRepository(): QuranRepository {
        val quranApiService = ApiConfig.getQuranService
        val adzanApiService = ApiConfig.getAdzanTimeService
        val remoteDataSource = RemoteDataSource(quranApiService, adzanApiService)
        return QuranRepository(remoteDataSource)
    }

//    fun provideAdzanRepository(): AdzanRepository {}
}