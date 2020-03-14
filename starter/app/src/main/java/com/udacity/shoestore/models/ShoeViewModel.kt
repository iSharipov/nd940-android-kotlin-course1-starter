package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private var shoes: MutableLiveData<List<Shoe>>? = null

    fun getShoes(): LiveData<List<Shoe>>? = shoes
}