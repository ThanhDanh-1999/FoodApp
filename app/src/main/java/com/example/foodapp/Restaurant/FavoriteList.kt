package com.example.foodapp.Restaurant


var favoriteList : List<Restaurant> = listOf()

val LIST_ITEM : Int = 0
val GRID_ITEM : Int = 1
var isSwitch : Boolean = true

fun switchItemView() : Boolean
{
    isSwitch = !isSwitch
    return isSwitch
}