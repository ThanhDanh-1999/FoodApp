package com.example.foodapp.movie

data class MovieRes (
        val dates: Dates? = null,
        val page: Long? = null,
        val results: List<MovieDetail>? = null,
        val totalPages: Long? = null,
        val totalResults: Long? = null
)

data class Dates (
        val maximum: String? = null,
        val minimum: String? = null
)

data class MovieDetail (
        val adult: Boolean? = null,
        val backdropPath: String? = null,
        val genreIDS: List<Long>? = null,
        val id: Long? = null,
        val originalLanguage: OriginalLanguage? = null,
        val originalTitle: String? = null,
        val overview: String? = null,
        val popularity: Double? = null,
        val posterPath: String? = null,
        val releaseDate: String? = null,
        val title: String? = null,
        val video: Boolean? = null,
        val voteAverage: Double? = null,
        val voteCount: Long? = null
)

enum class OriginalLanguage {
    En,
    Ja,
    Ko,
    Ru
}
