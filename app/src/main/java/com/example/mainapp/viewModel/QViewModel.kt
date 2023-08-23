package com.example.mainapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainapp.ApiInterface.QuotesApiInterface
import com.example.mainapp.Retroconfig.RetroConfigQ
import com.example.mainapp.Retroconfig.RetroConfigV
import com.example.mainapp.ApiInterface.VehicleApiInterface
import com.example.mainapp.Model.Result
import com.example.mainapp.Model.VehicleType
import kotlinx.coroutines.launch
import java.lang.Exception

class QViewModel: ViewModel() {
    var response = MutableLiveData<List<String>>()
    var list =MutableLiveData<List<Result>>()
    var list2 =MutableLiveData<kotlin.Result<VehicleType>>()
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