package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private val shoes: MutableLiveData<MutableList<Shoe>> = MutableLiveData()

    init {
        shoes.value = ArrayList()
    }

    fun getShoes(): LiveData<MutableList<Shoe>> = shoes
}