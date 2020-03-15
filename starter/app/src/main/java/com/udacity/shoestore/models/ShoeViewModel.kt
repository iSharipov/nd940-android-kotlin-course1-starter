package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private var shoes: MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())

    fun getShoes(): LiveData<MutableList<Shoe>> = shoes
}