package com.example.foodapp.Restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityRestaurantsBinding
import com.example.foodapp.databinding.RestaurantlistFragmentLayoutBinding

class RestaurantListFragment : Fragment(){
    private lateinit var binding: RestaurantlistFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.restaurantlist_fragment_layout,container,false)
        val adapter = RestaurantsAdapter()
        binding.retaurantList.adapter = adapter
        adapter.data = getRestaurants()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}