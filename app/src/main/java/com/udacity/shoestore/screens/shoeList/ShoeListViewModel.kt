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

    private fun randomCompanyName(): String {
        val companies = arrayOf("Clarks", "Nike", "Browns", "Kodiak", "Converse", "New Balance")
        return companies[(0 until 5).random()]
    }

    private fun randomSize(): Double {
        val size = (6 until 16).random()
        val ran = (0 until 1).random()

        return if (ran == 0) {
            size + 0.5
        } else {
            size.toDouble()
        }
    }

    private fun randomShoeName(): String {
        val companies = arrayOf("Evo", "Norma", "Day-T", "Retra", "Cory")
        return companies[(0 until 4).random()]
    }

    fun initShoeList() {
        for (i in 1..15) {
            val companyName = randomCompanyName()
            val size = randomSize()
            _shoeList.value?.add(Shoe(randomShoeName(), size, companyName, "$companyName $size"))
        }
    }
}