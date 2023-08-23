package com.example.mainapp.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class Vehicle(
    val Count: Int,
    val Message: String,
    val Results: List<Result>,
    val SearchCriteria: Any
)
@Parcelize
data class Result(
    val Country: String,
    val Mfr_CommonName: String,
    val Mfr_ID: Int,
    val Mfr_Name: String,
    val VehicleTypes: List<VehicleType>
):Parcelable
@Parcelize
data class VehicleType(
    val IsPrimary: Boolean,
    val Name: String
): Parcelable