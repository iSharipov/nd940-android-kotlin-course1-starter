package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Client(var email: String? = null, var password: String? = null) : Parcelable