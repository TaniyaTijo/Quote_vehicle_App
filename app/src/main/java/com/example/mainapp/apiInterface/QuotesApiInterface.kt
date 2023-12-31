package com.example.mainapp.apiInterface

import retrofit2.Response
import retrofit2.http.GET

interface QuotesApiInterface {
    @GET("/v2/quotes")
    suspend fun getRandomQuote():Response<List<String>>
}