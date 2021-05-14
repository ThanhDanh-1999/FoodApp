package com.example.foodapp.movie

import com.google.gson.annotations.SerializedName

data class MovieRes (
        val dates: Dates? = null,
        val page: Long? = null,
        val results: List<MovieDetail>? = null,
        @SerializedName("total_pages")
        val totalPages: Long? = null,

        @SerializedName("total_results")
        val totalResults: Long? = null
)

data class Dates (
        val maximum: String? = null,
        val minimum: String? = null
)

data class MovieDetail (
    @SerializedName("poster_path")
    val posterPath: String? = null,

    val adult: Boolean? = null,

    val overview: String? = null,

    @SerializedName("release_date")
    val releaseDate: String? = null,

    @SerializedName("genre_ids")
    val genreIDS: List<Long>? = null,

    val id: Long? = null,

    @SerializedName("original_title")
    val originalTitle: String? = null,

    @SerializedName("original_language")
    val originalLanguage: OriginalLanguage? = null,

    val title: String? = null,

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    val popularity: Double? = null,

    @SerializedName("vote_count")
    val voteCount: Long? = null,

    val video: Boolean? = null,

    @SerializedName("vote_average")
    val voteAverage: Double? = null
)

enum class OriginalLanguage {
    En,
    Ja,
    Ko,
    Ru
}
