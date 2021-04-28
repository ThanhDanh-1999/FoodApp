package com.example.foodapp.Restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityRestaurantsBinding
import kotlinx.android.synthetic.main.activity_restaurants.*

class RestaurantsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRestaurantsBinding
    private lateinit var viewModel: RestaurantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurants)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        val adapter = RestaurantsAdapter()
        binding.retaurantList.adapter = adapter
        adapter.data = getRestaurants()

        switch_layout_btn.setOnClickListener {
            adapter.switchItemView()
            if(adapter.switchItemView()) {
                retaurantList.layoutManager = GridLayoutManager(this, 2)
            }
            else {
                retaurantList.layoutManager = LinearLayoutManager(this)
            }
            adapter.switchItemView()
            adapter.notifyDataSetChanged()

        }
    }
}