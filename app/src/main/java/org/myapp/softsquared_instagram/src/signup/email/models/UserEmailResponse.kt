package org.myapp.softsquared_instagram.src.signup.email.models

import com.google.gson.annotations.SerializedName

class UserEmailResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String
)

