package com.example.mainapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class VViewModel: ViewModel() {
    var response1 = MutableLiveData<Result>()
    val response2: LiveData<Result> = response1
    var api = RetroConfigQ().getInstance().create(VehicleApiInterface::class.java)


    fun onItemClicked(item:Result){
        response1.value=item
    }
}