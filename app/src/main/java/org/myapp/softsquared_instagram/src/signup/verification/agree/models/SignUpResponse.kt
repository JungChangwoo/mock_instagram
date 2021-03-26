package org.myapp.softsquared_instagram.src.signup.verification.agree.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse

data class SignUpResponse(
    @SerializedName("result") val result : ResultSignUp
) : BaseResponse()
