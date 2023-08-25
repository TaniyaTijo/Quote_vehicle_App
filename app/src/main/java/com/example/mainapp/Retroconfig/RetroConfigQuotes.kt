package com.example.mainapp.Retroconfig

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroConfigQuotes {
    private var BASE_URL1="https://ron-swanson-quotes.herokuapp.com/"
    var BASE_URL2="https://vpic.nhtsa.dot.gov/"
    fun getQuoteInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL1)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getCarInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}