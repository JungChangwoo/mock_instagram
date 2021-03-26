package org.myapp.softsquared_instagram.src.signup.verification.agree.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest(
    @SerializedName("email") val email : String?,
    @SerializedName("phoneNum") val phoneNum : String?,
    @SerializedName("name") val name : String,
    @SerializedName("password") val password : String,
    @SerializedName("birth") val birth : String,
    @SerializedName("nickName") val nickName : String
)
