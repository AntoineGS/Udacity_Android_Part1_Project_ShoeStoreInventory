package com.udacity.shoestore.screens.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _onOpenDetail = MutableLiveData<Boolean>()
    val onOpenDetail : LiveData<Boolean>
        get() = _onOpenDetail

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = arrayListOf()
    }

    fun openDetail() {
        _onOpenDetail.value = true
        //reset to allow backPress to work
        _onOpenDetail.value = false
    }

    fun initShoeList() {
        for (i in 1..15) {
            _shoeList.value?.add(Shoe("Shoe", 11.5, "Clarks", "Brown shoes"))
        }
    }
}