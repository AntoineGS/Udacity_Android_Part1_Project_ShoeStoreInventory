package com.udacity.shoestore.screens.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {

    private val _onOpenDetail = MutableLiveData<Boolean>()
    val onOpenDetail : LiveData<Boolean>
        get() = _onOpenDetail

    fun openDetail() {
        _onOpenDetail.value = true
    }
}