package com.example.foodapp

import java.net.URL

fun getRestaurants():List<Restaurant>
{
    return listOf(
        Restaurant("Du Miên Garden Cafe - Phan Văn Trị","7 Phan Văn Trị, P. 10", URL("https://images.foody.vn/res/g4/33760/prof/s180x180/foody-mobile-du-mien-garden-mb-jp-309-635785114907746480.jpg")),
        Restaurant("Country House Cafe","18C Phan Văn Trị, P. 10",URL("https://images.foody.vn/res/g1/978/prof/s180x180/foody-mobile-countryhouse-jpg-246-635683259648435945.jpg")),
        Restaurant("Hẻm Spaghetti - Nguyễn Oanh","212/22 Nguyễn Oanh, P. 17",URL("https://images.foody.vn/res/g9/82801/prof/s180x180/foody-upload-api-foody-mobile-gi4-jpg-181001160804.jpg")),


    )
}