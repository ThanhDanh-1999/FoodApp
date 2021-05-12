package com.example.foodapp.Movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.foodapp.R

class MovieActivity : AppCompatActivity() {

    private lateinit var viewModel : MovieActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        viewModel = ViewModelProvider(this).get(MovieActivityViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        viewModel.getData()
    }
}