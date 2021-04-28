package com.example.foodapp.Restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.foodapp.R
import com.example.foodapp.databinding.RestaurantlistFragmentLayoutFavoriteBinding

class RestaurantListFragmentFavorite(val data : List<Restaurant>)  : Fragment(){
    private lateinit var binding : RestaurantlistFragmentLayoutFavoriteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.restaurantlist_fragment_layout_favorite,container,false)
        val adapter = FavoriteListAdapter(data)
        binding.FavRetaurantList.adapter = adapter



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}