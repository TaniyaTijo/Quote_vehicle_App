package com.example.mainapp

import retrofit2.Response
import retrofit2.http.GET
import kotlin.Result

interface VehicleApiInterface {
    @GET("/api/vehicles/getallmanufacturers?format=json")
    suspend fun getAllData(): Response<Vehicle>
}