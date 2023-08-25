package com.example.mainapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainapp.apiInterface.QuotesApiInterface
import com.example.mainapp.Retroconfig.RetroConfigQuotes
import com.example.mainapp.ApiInterface.VehicleApiInterface
import com.example.mainapp.Model.Result
import kotlinx.coroutines.launch
import java.lang.Exception

class QuotesViewModel: ViewModel() {
    var response = MutableLiveData<List<String>>()
    var list =MutableLiveData<List<Result>>()
    var api = RetroConfigQuotes().getQuoteInstance().create(QuotesApiInterface::class.java)
    var listapi = RetroConfigQuotes().getCarInstance().create(VehicleApiInterface::class.java)
    fun getRandomQuote() {
        try{
            viewModelScope.launch{
                val res = api.getRandomQuote()
                response.value=res.body()
            }
        }catch (e:Exception){
            println(e.message)
        }
    }
    fun getCarManufacureList() {
        viewModelScope.launch {
            val res = listapi.getAllData()
            list.value = res.body()?.Results
        }
    }
}