package com.example.lab9.models

import android.provider.ContactsContract.CommonDataKinds.Email

data class User(
    var id: Int,
    var login: String = "",
    var password: String = "",
    var email: Email
)
