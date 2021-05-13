package com.example.foodapp.movie.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.movie.MovieRes
import com.example.foodapp.movie.rest.RestClient
import kotlinx.coroutines.launch

class NowPlayingMoviesViewModel : ViewModel() {

    fun getData(): MovieRes {
        var movieResp = MovieRes()
        viewModelScope.launch {
            movieResp = RestClient.getInstance().API.listNowPlayingMovie(
                "en-US",
                1,
                "ec3dc35863da495920afb66612ea0e50")
            Log.e("TAG", movieResp.results.toString())
        }
        return movieResp
    }
}