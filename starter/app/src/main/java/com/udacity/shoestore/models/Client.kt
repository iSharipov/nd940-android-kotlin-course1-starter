package com.udacity.shoestore.models

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Client : ViewModel() {
    val email = ObservableField<String>()
    val password = ObservableField<String>()

    private val client: MutableLiveData<Client> = MutableLiveData()

    fun getClient(): LiveData<Client> = client
}