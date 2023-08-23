package com.example.mainapp.ApiInterface

import com.example.mainapp.Model.Vehicle
import retrofit2.Response
import retrofit2.http.GET

interface VehicleApiInterface {
    @GET("/api/vehicles/getallmanufacturers?format=json")
    suspend fun getAllData(): Response<Vehicle>
}