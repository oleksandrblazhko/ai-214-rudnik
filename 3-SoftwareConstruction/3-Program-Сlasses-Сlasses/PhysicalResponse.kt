package com.example.lab9.models

import java.util.Date

data class PhysicalResponse(
    var id: Int,
    var responseText: String = "",
    var date: Date,
    var request: PhysicalRequest
)
