package com.nori.quranapp.network.adzan

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DailyResponse(
    @Json(name = "data")
    val dailyData: DailyData,

    @Json(name = "status")
    val status: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class DailyData(
    @Json(name = "schedule")
    val scheduleItem: ScheduleItem,

    @Json(name = "location")
    val location: String? = null,

    @Json(name = "area")
    val area: String? = null,

    @Json(name = "id")
    val id: String? = null
)

@JsonClass(generateAdapter = true)
data class ScheduleItem(
    @Json(name = "date")
    val date: String? = null,

    @Json(name = "imsak")
    val imsak: String? = null,

    @Json(name = "rise")
    val rise: String? = null,

    @Json(name = "fajr")
    val fajr: String? = null,

    @Json(name = "duha")
    val duha: String? = null,

    @Json(name = "zuhr")
    val zuhr: String? = null,

    @Json(name = "asr")
    val asr: String? = null,

    @Json(name = "maghrib")
    val maghrib: String? = null,

    @Json(name = "isha")
    val isha: String? = null,
)