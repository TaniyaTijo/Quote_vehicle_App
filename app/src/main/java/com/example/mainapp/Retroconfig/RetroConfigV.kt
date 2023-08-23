package com.example.mainapp.Retroconfig

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroConfigV {
    var BASE_URL="https://vpic.nhtsa.dot.gov/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}