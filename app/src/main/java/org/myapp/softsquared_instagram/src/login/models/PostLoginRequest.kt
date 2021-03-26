package org.myapp.softsquared_instagram.src.login.models

import com.google.gson.annotations.SerializedName

data class PostLoginRequest(
    @SerializedName("nickName") val nickName : String,
    @SerializedName("password") val password : String
)
