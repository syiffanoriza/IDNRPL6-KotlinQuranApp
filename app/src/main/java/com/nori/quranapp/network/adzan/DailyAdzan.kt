package com.nori.quranapp.network.adzan

data class DailyAdzan(
    val date: String? = null,
    val imsak: String? = null,
    val rise: String? = null,
    val fajr: String? = null,
    val duha: String? = null,
    val zuhr: String? = null,
    val asr: String? = null,
    val maghrib: String? = null,
    val isha: String? = null
)
