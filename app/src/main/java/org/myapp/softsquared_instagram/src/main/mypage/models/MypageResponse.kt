package org.myapp.softsquared_instagram.src.main.mypage.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse

data class MypageResponse(
    @SerializedName("result") val result : ResultMypage
) : BaseResponse()
