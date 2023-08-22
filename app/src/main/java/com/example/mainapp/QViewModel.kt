package com.example.mainapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.create
import java.lang.Exception

class QViewModel: ViewModel() {
    var response = MutableLiveData<List<String>>()
    var list =MutableLiveData<List<Result>>()
    var api = RetroConfigQ().getInstance().create(QuotesApiInterface::class.java)
    var Listapi = RetroConfigV().getInstance().create(VehicleApiInterface::class.java)

    fun getRandomQuote() {
        try{
            viewModelScope.launch{
                var res = api.getRandomQuote()
                response.value=res.body()
            }
        }catch (e:Exception){
            println(e.message)
        }
    }
    fun getCarManufacureList() {
        viewModelScope.launch {
            var res = Listapi.getAllData()
            list.value = res.body()?.Results
        }
    }
}