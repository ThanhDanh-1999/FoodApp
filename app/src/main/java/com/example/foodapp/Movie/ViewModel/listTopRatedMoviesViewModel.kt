package com.example.foodapp.Movie.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.Movie.MovieResp
import com.example.foodapp.Movie.rest.RestClient
import kotlinx.coroutines.launch

class ListTopRatedMoviesViewModel : ViewModel() {

    fun getData(): MovieResp {
        var movieResp = MovieResp()
        viewModelScope.launch {
            movieResp = RestClient.getInstance().API.listTopRatedMovie(
                "en-US",
                1,
                "ec3dc35863da495920afb66612ea0e50")
            Log.e("TAG", movieResp.results.toString())
        }
        return movieResp
    }
}