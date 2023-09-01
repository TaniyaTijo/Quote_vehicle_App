package com.example.carsapp.viewmodal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainapp.apiInterface.LoginApiInterface
import com.example.mainapp.model.LoginRequest
import com.example.mainapp.model.Login
import com.example.mainapp.retroconfig.RetroConfigQuotes
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private var response = MutableLiveData<Login>()
    private var api = RetroConfigQuotes().getQuoteInstance().create(LoginApiInterface::class.java)
    var liveData = MutableLiveData<Boolean>()
    var userData = MutableLiveData<Login>()
    private val loginApi = RetroConfigQuotes().getLoginInstance().create(LoginApiInterface::class.java)
    fun validateInput(username: String, password: String): Boolean {
        return !(username.isEmpty() || password.isEmpty())
    }

    fun loginUser(username: String, password: String) {
        val loginRequest = LoginRequest(username, password)
        viewModelScope.launch {
            try {
                val res = loginApi.getUsers(loginRequest)
                liveData.value = res.isSuccessful
                userData.value = res.body()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
    fun getUserDetail() {
        viewModelScope.launch{
            val res = api.getUserDetails()
            response.value=res.body()
        }

    }

}