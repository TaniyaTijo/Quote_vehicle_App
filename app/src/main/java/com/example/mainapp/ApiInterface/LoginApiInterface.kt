package com.example.mainapp.apiInterface

import com.example.mainapp.model.LoginRequest
import com.example.mainapp.model.LoginRes

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiInterface {
    @POST("auth/login")
    suspend fun getUsers(@Body loginRequest: LoginRequest):Response<LoginRes>
}