package com.danielg07.rickandmorty.network

data class Info(
    val count: Int,
    val next: String? = "",
    val pages: Int,
    val prev: String? = ""
)