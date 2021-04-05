package org.myapp.softsquared_instagram.src.main.home.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse

data class PostLikeResponse(
    @SerializedName("result") val result : ResultLike
): BaseResponse()
