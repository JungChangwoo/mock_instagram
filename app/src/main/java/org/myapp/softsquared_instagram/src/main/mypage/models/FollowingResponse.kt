package org.myapp.softsquared_instagram.src.main.mypage.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.ResultSignUp

data class FollowingResponse(
    @SerializedName("result") val result : ResultFollowing
) : BaseResponse()
