package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.databinding.ActivityRestaurantsBinding

class RestaurantsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRestaurantsBinding
    private lateinit var viewModel: RestaurantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_restaurants)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        val adapter = RestaurantsAdapter()
        binding.retaurantList.adapter = adapter
        adapter.data = getRestaurants()
    }
}