package com.example.foodapp.Movie.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.Movie.Movie
import com.example.foodapp.Movie.NowPlayingMoviesViewModel
import com.example.foodapp.R
import com.example.foodapp.Restaurant.FavoriteListAdapter
import com.example.foodapp.SignUp.SignUpViewModel
import com.example.foodapp.databinding.MovieFragmentBinding

class NowPlayingFragment : Fragment() {
    private lateinit var binding: MovieFragmentBinding
    private lateinit var adapter: NowPlayingFragmentAdapter
    private lateinit var viewModel: NowPlayingMoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(NowPlayingMoviesViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.movie_fragment, container, false)

        viewModel.getData()
        viewModel.movieList.observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "${it.toString()}")
            //adapter.setDataList(it)
        })

        adapter = NowPlayingFragmentAdapter(requireContext())

        binding.npMovieList.adapter = adapter
        adapter.setDataList(listOf(Movie("phim fake")))
        setHasOptionsMenu(true)
        return binding.root
    }

}