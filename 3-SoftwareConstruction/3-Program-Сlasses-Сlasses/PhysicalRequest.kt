package com.example.lab9.models

import java.util.Date

data class PhysicalRequest(
    var id: Int,
    var purpose: String = "",
    var date: Date,
    var user: User
)
