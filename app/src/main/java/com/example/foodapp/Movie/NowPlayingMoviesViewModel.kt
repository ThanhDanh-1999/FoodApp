package com.example.foodapp.Movie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.Movie.rest.RestClient
import kotlinx.coroutines.launch

class NowPlayingMoviesViewModel : ViewModel() {

    fun getData(): List<Movie>? {
        var movieResp = MovieResp()
        viewModelScope.launch {
            movieResp = RestClient.getInstance().API.listNowPlayingMovie(
               "en-US",
               1,
               "7329758a578ec893b84930c8f1cc3919")
            Log.e("TAG", movieResp.results.toString())
        }
        Log.e("TAG", movieResp.results?.get(0)?.title.toString())
        return movieResp.results
    }
}