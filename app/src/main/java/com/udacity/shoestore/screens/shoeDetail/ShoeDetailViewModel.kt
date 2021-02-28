package com.udacity.shoestore.screens.shoeDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel() {

    private val _onSave = MutableLiveData<Boolean>()
    val onSave : LiveData<Boolean>
        get() = _onSave

    private val _onCancel = MutableLiveData<Boolean>()
    val onCancel: LiveData<Boolean>
        get() = _onCancel

    private val _shoe = MutableLiveData<Shoe>()
    val shoe : LiveData<Shoe>
        get() = _shoe

    init {
        _shoe.value = Shoe("123", 0.0, "", "")
    }

    fun cancel() {
        _onCancel.value = true
        _onCancel.value = false
    }

    fun save() {
        _onSave.value = true
        _onSave.value = false
    }
}