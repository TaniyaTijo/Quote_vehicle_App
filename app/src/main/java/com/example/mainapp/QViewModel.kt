package com.example.mainapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class QViewModel: ViewModel() {
    var response = MutableLiveData<List<String>>()

    var api = RetroConfigQ().getInstance().create(QuotesApiInterface::class.java)


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
}