package com.example.mainapp

data class Vehicle(
    val Count: Int,
    val Message: String,
    val Results: List<Result>,
    val SearchCriteria: Any
)
data class Result(
    val Country: String,
    val Mfr_CommonName: String,
    val Mfr_ID: Int,
    val Mfr_Name: String,
    val VehicleTypes: List<VehicleType>
)
data class VehicleType(
    val IsPrimary: Boolean,
    val Name: String
)