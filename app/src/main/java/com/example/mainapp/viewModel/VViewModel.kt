package com.example.mainapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainapp.ApiInterface.VehicleApiInterface
import com.example.mainapp.Model.Result
import com.example.mainapp.Model.VehicleType
import com.example.mainapp.Retroconfig.RetroConfigV
import kotlinx.coroutines.launch
import java.lang.Exception

class VViewModel: ViewModel() {
    var response1 = MutableLiveData<List<Result>>()
    var response2 = MutableLiveData<List<VehicleType>>()

//    val response2: LiveData<Result> = response1
    var api = RetroConfigV().getInstance().create(VehicleApiInterface::class.java)


//    fun onItemClicked(item:Result){
//        response1.value=item
//    }
    fun getCarManufacureList() {
        viewModelScope.launch {
            var res = api.getAllData()
            response1.value = res.body()?.Results
        }
    }
}