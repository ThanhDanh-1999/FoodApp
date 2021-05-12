package com.example.foodapp.Movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.Movie.Fragments.NowPlayingFragment
import com.example.foodapp.R
import com.example.foodapp.Restaurant.RestaurantListFragmentFavorite
import com.example.foodapp.Restaurant.RestaurantListFragmentTop
import com.example.foodapp.Restaurant.favoriteList
import kotlinx.android.synthetic.main.activity_movie.*
import kotlinx.android.synthetic.main.activity_restaurants.*

class MovieActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        loadFragment(NowPlayingFragment())

        movieBottomNavigationBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Nowplaying_btn->{
                    loadFragment(NowPlayingFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Toprated_btn->{
                    loadFragment(NowPlayingFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //reused
        menuInflater.inflate(R.menu.restaurant_activity_menubar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun loadFragment(fragment : Fragment)
    {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.movie_listview,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}