package com.nori.quranapp.network.adzan

import androidx.lifecycle.LiveData
import com.nori.quranapp.network.Resource
import kotlinx.coroutines.flow.Flow
import java.time.Year

interface IAdzanRepository {
    fun getLastKnownLocation(): LiveData<List<String>>
    fun searchCity(city: String): Flow<Resource<List<City>>>

    fun getDailyAdzanTime(
        id: String,
        year: String,
        month: String,
        date: String
    ): Flow<Resource<DailyAdzan>>
}