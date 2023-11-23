package com.nori.quranapp.utils

import com.nori.quranapp.network.adzan.City
import com.nori.quranapp.network.adzan.CityItem
import com.nori.quranapp.network.adzan.DailyAdzan
import com.nori.quranapp.network.adzan.ScheduleItem
import com.nori.quranapp.network.quran.Ayah
import com.nori.quranapp.network.quran.AyahsItem
import com.nori.quranapp.network.quran.QuranEdition
import com.nori.quranapp.network.quran.QuranEditionItem
import com.nori.quranapp.network.quran.Surah
import com.nori.quranapp.network.quran.SurahItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object DataMapper {

    @JvmName("mapSurahResponseToDomain")
    fun mapResponseToDomain(input: List<SurahItem>): Flow<List<Surah>> {
        val listSurah = ArrayList<Surah>()
        input.map {
            val surah = Surah(
                number = it.number,
                name = it.name,
                englishName = it.englishName,
                englishNameTranslation = it.englishNameTranslation,
                numberOfAyahs = it.numberOfAyahs,
                revelationType = it.revelationType
            )
            listSurah.add(surah)
        }
        return flowOf(listSurah)
    }

    @JvmName("mapQuranEditionResponseToDomain")
    fun mapResponseToDomain(input: List<QuranEditionItem>): Flow<List<QuranEdition>> {
        val listQuranEdition = ArrayList<QuranEdition>()
        input.map {
            val quranEdition = QuranEdition(
                number = it.number,
                name = it.name,
                englishName = it.englishName,
                englishNameTranslation = it.engishNameTranslation,
                revelationType = it.revelationType,
                numberOfAyahs = it.numberOfAyahs,
                listAyahs = mapListAyahResponseToDomain(it.listAyahs)
            )
            listQuranEdition.add(quranEdition)
        }
        return flowOf(listQuranEdition)
    }

    private fun mapListAyahResponseToDomain(input: List<AyahsItem>): List<Ayah> {
        val listAyah = ArrayList<Ayah>()
        input.map {
            val ayah = Ayah(
                number = it.number,
                text = it.text,
                numberInSurah = it.numberInSurah,
                audio = it.audio
            )
            listAyah.add(ayah)
        }
        return listAyah
    }

    @JvmName("mapCityResponseToDomain")
    fun mapResponseToDomain(input: List<CityItem>): Flow<List<City>> {
        val listCity = ArrayList<City>()
        input.map {
            val city = City(
                location = it.location,
                id = it.id
            )
            listCity.add(city)
        }
        return flowOf(listCity)
    }

    @JvmName("mapDailyResponseToDomain")
    fun mapResponseToDomain(input: ScheduleItem): Flow<DailyAdzan> {
        val dailyAdzan = DailyAdzan(
            date = input.date,
            imsak = input.imsak,
            rise = input.rise,
            fajr = input.fajr,
            duha = input.duha,
            zuhr = input.zuhr,
            asr = input.asr,
            maghrib = input.maghrib,
            isha = input.isha
        )
        return flowOf(dailyAdzan)
    }
}