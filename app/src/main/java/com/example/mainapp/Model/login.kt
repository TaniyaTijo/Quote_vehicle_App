package com.example.mainapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequest(
    @SerializedName("username")
    var username:String,
    @SerializedName("password")
    var password:String
): Parcelable

@Parcelize
data class Login(
    var id:Int,
    var username:String,
    var message:String,
    val email: String,
    val firstName: String,
    val gender: String,
    val image: String,
    val lastName: String
): Parcelable


