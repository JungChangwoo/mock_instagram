package org.myapp.softsquared_instagram.src.signup.phone.models

import com.google.gson.annotations.SerializedName

data class UserPhoneResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String
)
