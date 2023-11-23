package com.nori.quranapp.network

import com.nori.quranapp.network.adzan.AdzanApiService
import com.nori.quranapp.network.quran.QuranApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiConfig {
    private inline fun <reified T> createService(baseUrl: String): T {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(T::class.java)
    }

    val getQuranService = createService<QuranApiService>("https://api.alquran.cloud/v1/")

    val getAdzanTimeService = createService<AdzanApiService>("https://api.myquran.com/v1/")
}