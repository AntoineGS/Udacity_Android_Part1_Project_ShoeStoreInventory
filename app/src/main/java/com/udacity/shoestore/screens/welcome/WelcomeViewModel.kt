package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel: ViewModel() {

    private val _eventOnRead = MutableLiveData<Boolean>()
    val eventOnRead: LiveData<Boolean>
        get() = _eventOnRead

    fun onRead() {
        _eventOnRead.value = true
    }
}