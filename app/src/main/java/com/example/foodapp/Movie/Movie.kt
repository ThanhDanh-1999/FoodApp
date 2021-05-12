package com.example.foodapp.Movie

data class Movie (
        val posterPath: String? = null,
        val adult: Boolean? = null,
        val overview: String? = null,
        val releaseDate: String? = null,
        val genreIDS: List<Long>? = null,
        val id: Long? = null,
        val originalTitle: String? = null,
        val originalLanguage: OriginalLanguage? = null,
        val title: String? = null,
        val backdropPath: String? = null,
        val popularity: Double? = null,
        val voteCount: Long? = null,
        val video: Boolean? = null,
        val voteAverage: Double? = null
)

enum class OriginalLanguage {
    En,
    Sv
}