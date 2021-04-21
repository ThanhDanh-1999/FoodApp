package com.example.foodapp

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.InputStream
import java.lang.Exception

class RestaurantsAdapter : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>(){

    var data : List<Restaurant> = listOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.restaurant_linear_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = data[position]
        holder.name.text = item.name
        holder.address.text = item.address
        try {
            val link : InputStream = item.pictureLink.getContent() as InputStream
            holder.picture.setImageDrawable(Drawable.createFromStream(link,"pic"))
        }catch (e : Exception){
            holder.picture.setImageDrawable(null)
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }
    class ViewHolder(val itemView : View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.restaurantName)
        val address = itemView.findViewById<TextView>(R.id.restaurantAddress)
        val picture = itemView.findViewById<ImageView>(R.id.restaurantPic)
    }
}