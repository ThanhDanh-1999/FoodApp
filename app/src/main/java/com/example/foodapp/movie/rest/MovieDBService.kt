package com.example.foodapp.movie.rest

import com.example.foodapp.movie.MovieRes
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBService {
    @GET("movie/now_playing")
    suspend fun listNowPlayingMovie(
            @Query("language")language : String,
            @Query("page")page : Int,
            @Query("api_key")apiKey : String
    ) : MovieRes

    @GET("movie/top_rated")
    suspend fun listTopRatedMovie(
            @Query("language")language : String,
            @Query("page")page : Int,
            @Query("api_key")apiKey : String
    ) : MovieRes
}