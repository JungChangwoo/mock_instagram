package org.myapp.softsquared_instagram.src.main.home.comments.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse

data class PostCommentsResponse(
    @SerializedName("result") val result : ResultPostComments
): BaseResponse()
