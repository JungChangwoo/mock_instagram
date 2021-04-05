package org.myapp.softsquared_instagram.src.main.home.delete.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse

data class FeedDeleteResponse(
    @SerializedName("result") val result : ResultResponse
):BaseResponse()
