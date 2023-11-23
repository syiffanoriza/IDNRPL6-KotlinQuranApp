package com.nori.quranapp.network

import android.util.Log
import com.nori.quranapp.network.adzan.AdzanApiService
import com.nori.quranapp.network.quran.QuranApiService
import com.nori.quranapp.network.quran.QuranEditionItem
import com.nori.quranapp.network.quran.SurahItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource (
    private val quranApiService: QuranApiService,
    private val adzanApiService: AdzanApiService
) {
    suspend fun getListSurah(): Flow<NetworkResponse<List<SurahItem>>> =
        flow {
            try {
                val surahResponse = quranApiService.getListSurah()
                val listSurah = surahResponse.listSurah
                emit(NetworkResponse.Success(listSurah))
            } catch (e: Exception) {
                emit(NetworkResponse.Error(e.toString()))
                Log.e(
                    RemoteDataSource::class.java.simpleName,
                    "getListSurah: " + e.localizedMessage
                )
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getDetailSurahQithQuranEditions(number: Int):
            Flow<NetworkResponse<List<QuranEditionItem>>> =
        flow {
            try {
                val ayahResponse = quranApiService.getDetailSurahWithQuranEditions(number)
                val quranEdition = ayahResponse.quranEdition
                emit(NetworkResponse.Success(quranEdition))
            } catch (e: Exception) {
                emit(NetworkResponse.Error(e.toString()))
                Log.e(
                    RemoteDataSource::class.java.simpleName,
                    "getListSurah: " + e.localizedMessage
                )
            }
        }.flowOn(Dispatchers.IO)
}