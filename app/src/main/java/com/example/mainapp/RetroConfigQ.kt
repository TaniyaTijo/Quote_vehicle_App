package com.example.mainapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroConfigQ {
    var BASE_URL="https://ron-swanson-quotes.herokuapp.com/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}