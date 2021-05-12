package com.example.foodapp.Movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.Movie.rest.RestClient
import kotlinx.coroutines.launch

class NowPlayingMoviesViewModel : ViewModel() {

    fun getData() : MovieResp{
        var movieResp = MovieResp()
        viewModelScope.launch {
           movieResp = RestClient.getInstance().API.listNowPlayingMovie(
               "en-US",
               1,
               "7329758a578ec893b84930c8f1cc3919")
        }
        return movieResp
    }
}