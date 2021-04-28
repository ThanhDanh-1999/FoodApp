package com.example.foodapp.Restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityRestaurantsBinding
import kotlinx.android.synthetic.main.activity_restaurants.*

class RestaurantsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRestaurantsBinding
    private lateinit var viewModel: RestaurantViewModel

    var favoriteList: List<Restaurant> = listOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurants)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        loadFragment(RestaurantListFragmentTop())

        restaurantBottomNavigationBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Top_btn->{
                    loadFragment(RestaurantListFragmentTop())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Favorite_btn->{
                    loadFragment(RestaurantListFragmentFavorite(favoriteList))
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }

    }

    private fun loadFragment(fragment : Fragment)
    {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.listRestaurant_fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}