package org.myapp.softsquared_instagram.src.login.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.ResultSignUp

data class LoginResponse(
    @SerializedName("result") val result : ResultLogin
) : BaseResponse()

