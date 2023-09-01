package com.example.mainapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainapp.apiInterface.QuotesApiInterface
import com.example.mainapp.retroconfig.RetroConfigQuotes
import com.example.mainapp.apiInterface.VehicleApiInterface
import com.example.mainapp.model.Result
import kotlinx.coroutines.launch
class QuotesViewModel: ViewModel() {
    var response = MutableLiveData<List<String>>()
    var list =MutableLiveData<List<Result>>()
    private var api = RetroConfigQuotes().getQuoteInstance().create(QuotesApiInterface::class.java)
    private var listapi = RetroConfigQuotes().getCarInstance().create(VehicleApiInterface::class.java)
    fun getRandomQuote() {
            viewModelScope.launch{
                val res = api.getRandomQuote()
                response.value=res.body()
            }
    }
    fun getCarManufacureList() {
        viewModelScope.launch {
            val res = listapi.getAllData()
            list.value = res.body()?.Results
        }
    }
}