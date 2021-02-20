package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _eventOnLogin = MutableLiveData<Boolean>()
    val eventOnLogin : LiveData<Boolean>
        get() = _eventOnLogin

    fun onLogin() {
        _eventOnLogin.value = true
        //reset to allow backPress to work
        _eventOnLogin.value = false
    }
}