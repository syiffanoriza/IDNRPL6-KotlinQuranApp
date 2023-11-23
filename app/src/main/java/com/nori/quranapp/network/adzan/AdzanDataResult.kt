package com.nori.quranapp.network.adzan

import com.nori.quranapp.network.Resource
import java.util.Calendar

data class AdzanDataResult(
    val listLocation: List<String>,
    val dailyAdzan: Resource<DailyAdzan>,
    val listCalendar: List<String>
)
