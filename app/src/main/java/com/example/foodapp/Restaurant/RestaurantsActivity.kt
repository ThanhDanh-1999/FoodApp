package com.example.foodapp.Restaurant

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
import kotlinx.android.synthetic.main.restaurantlist_fragment_layout_favorite.*
import kotlinx.android.synthetic.main.restaurantlist_fragment_layout_top.*

class RestaurantsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRestaurantsBinding
    private lateinit var viewModel: RestaurantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurants)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        //loadFragment(RestaurantListFragmentFavorite(favoriteList))
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.restaurant_activity_menubar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {

            R.id.displayMode -> {
                switchItemView()
                if (item.title == "List") {
                    item.icon = resources.getDrawable(R.drawable.ic_grid)
                    item.title = "Grid"
                    //FavRetaurantList.layoutManager = GridLayoutManager(applicationContext,2)
                    retaurantList.layoutManager = GridLayoutManager(applicationContext,2)

                    return true
                } else {
                    item.icon = resources.getDrawable(R.drawable.ic_list)
                    item.title = "List"
                    //FavRetaurantList.layoutManager = LinearLayoutManager(applicationContext)
                    retaurantList.layoutManager = LinearLayoutManager(applicationContext)

                    return true
                }
            }
            else -> return false
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