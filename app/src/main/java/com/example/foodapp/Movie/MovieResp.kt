package com.example.foodapp.Movie

data class MovieResp (
        val page: Long? = null,
        val results: List<Movie>? = null,
        val dates: Dates? = null,
        val totalPages: Long? = null,
        val totalResults: Long? = null
)

data class Dates (
        val maximum: String? = null,
        val minimum: String? = null
)
