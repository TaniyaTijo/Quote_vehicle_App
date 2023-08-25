package com.example.mainapp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainapp.ApiInterface.VehicleApiInterface
import com.example.mainapp.Model.Result
import com.example.mainapp.Retroconfig.RetroConfigQuotes
import kotlinx.coroutines.launch
class VehicleViewModel: ViewModel() {
    private var response1 = MutableLiveData<List<Result>>()
    private var api = RetroConfigQuotes().getCarInstance().create(VehicleApiInterface::class.java)

    fun getCarManufacureList() {
        viewModelScope.launch {
            val res = api.getAllData()
            response1.value = res.body()?.Results
        }
    }
}