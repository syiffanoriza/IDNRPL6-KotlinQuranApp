package com.nori.quranapp.presentation.adzan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nori.quranapp.network.Resource
import com.nori.quranapp.network.adzan.AdzanDataResult
import com.nori.quranapp.network.adzan.AdzanRepository

class AdzanViewModel (
    private val adzanRepository: AdzanRepository
) : ViewModel() {
    fun getDailyAdzanTime():
        LiveData<Resource<AdzanDataResult>> = adzanRepository
            .getResultDailyAdzanTime()
}