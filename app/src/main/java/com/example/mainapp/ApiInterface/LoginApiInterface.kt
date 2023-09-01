package com.example.mainapp.apiInterface

import com.example.mainapp.model.LoginRequest
import com.example.mainapp.model.Login

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginApiInterface {
    @POST("auth/login")
    suspend fun getUsers(@Body loginRequest: LoginRequest):Response<Login>
    @GET("/users")
    suspend fun getUserDetails():Response<Login>
}