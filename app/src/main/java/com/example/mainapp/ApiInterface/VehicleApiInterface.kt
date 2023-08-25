package com.example.mainapp.apiInterface

import com.example.mainapp.model.Vehicle
import retrofit2.Response
import retrofit2.http.GET

interface VehicleApiInterface {
    @GET("/api/vehicles/getallmanufacturers?format=json")
    suspend fun getAllData(): Response<Vehicle>
}