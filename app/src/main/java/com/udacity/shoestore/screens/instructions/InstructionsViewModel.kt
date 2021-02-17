package com.udacity.shoestore.screens.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel: ViewModel() {

    private val _eventOnRead = MutableLiveData<Boolean>()
    val eventOnRead: LiveData<Boolean>
        get() = _eventOnRead

    fun onRead() {
        _eventOnRead.value = true
    }
}