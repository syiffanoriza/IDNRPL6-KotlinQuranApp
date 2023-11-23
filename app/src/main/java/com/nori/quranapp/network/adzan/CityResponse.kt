package com.nori.quranapp.network.adzan

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityResponse(
    @Json(name = "data")
    val dataCity: List<CityItem>,

    @Json(name = "status")
    val status: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class CityItem(
    @Json(name = "location")
    val location: String? = null,

    @Json(name = "id")
    val id: String? = null
)