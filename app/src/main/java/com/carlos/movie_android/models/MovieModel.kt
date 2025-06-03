package com.carlos.movie_android.models

data class MovieModel(
    val id: String,
    val title: String,
    val year: Int,
    val genre: String,
    val synopsis: String,
    val imageUrl: String
)
