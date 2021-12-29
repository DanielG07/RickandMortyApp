package com.danielg07.rickandmorty.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

data class ListRickAndMortyProperty(
    val info: infoProperty,
    @Json(name = "results")val list: List<RickAndMortyProperty>
)

data class infoProperty(
    @Json(name = "next") val nextUrl: String?,
    @Json(name = "prev") val prevUrl: String?
)

data class RickAndMortyProperty(
    val id: Int,
    val name: String,
    val status: String,
    @Json(name = "url") val imgUrl: String,
    @Json(name = "location") val lastSeen: lastSeen
    )


data class lastSeen(
    val name: String
)