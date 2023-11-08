package com.example.lab9.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WorksList(
    var worksCode:String = "",
    var worksName:String = "",
    var worksGenre:String = "",
    var worksAuthor:String = "") : Parcelable
