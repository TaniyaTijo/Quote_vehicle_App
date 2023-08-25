package com.example.mainapp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainapp.apiInterface.VehicleApiInterface
import com.example.mainapp.model.Result
import com.example.mainapp.retroconfig.RetroConfigQuotes
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