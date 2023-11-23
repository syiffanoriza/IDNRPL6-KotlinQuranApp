package com.nori.quranapp.network.di

import android.content.Context
import com.nori.quranapp.local.CalendarPreferences
import com.nori.quranapp.local.LocationPreferences
import com.nori.quranapp.network.ApiConfig
import com.nori.quranapp.network.RemoteDataSource
import com.nori.quranapp.network.adzan.AdzanApiService
import com.nori.quranapp.network.adzan.AdzanRepository
import com.nori.quranapp.network.quran.QuranRepository

object Injection {
    val quranApiService = ApiConfig.getQuranService
    val adzanApiService = ApiConfig.getAdzanTimeService
    val remoteDataSource = RemoteDataSource(quranApiService, adzanApiService)
    fun provideQuranRepository(): QuranRepository {
        return QuranRepository(remoteDataSource)
    }

    fun provideAdzanRepository(context: Context): AdzanRepository {
        val locationPreferences = LocationPreferences(context)
        val calendarPreferences = CalendarPreferences()
        return AdzanRepository(remoteDataSource, locationPreferences, calendarPreferences)
    }
}