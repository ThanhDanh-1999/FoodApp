package com.example.foodapp.Movie.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.Movie.Movie
import com.example.foodapp.Movie.NowPlayingMoviesViewModel
import com.example.foodapp.R
import com.example.foodapp.Restaurant.FavoriteListAdapter
import com.example.foodapp.SignUp.SignUpViewModel
import com.example.foodapp.databinding.MovieFragmentBinding

class NowPlayingFragment : Fragment(){
    private lateinit var binding : MovieFragmentBinding
    private lateinit var adapter: NowPlayingFragmentAdapter
    private lateinit var viewModel : NowPlayingMoviesViewModel

    private var data : List<Movie>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(NowPlayingMoviesViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.movie_fragment,container,false)
        data = viewModel.getData().results as? List<Movie>
        adapter = NowPlayingFragmentAdapter(data)
        if(adapter != null) binding.npMovieList.adapter = adapter
        setHasOptionsMenu(true)
        return binding.root
    }

}