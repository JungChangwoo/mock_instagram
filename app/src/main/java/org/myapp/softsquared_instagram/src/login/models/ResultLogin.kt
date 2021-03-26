package org.myapp.softsquared_instagram.src.login.models

import com.google.gson.annotations.SerializedName

data class ResultLogin(
    @SerializedName("userIdx") val userIdx : Int,
    @SerializedName("jwt") val jwt : String
)
