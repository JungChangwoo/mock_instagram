package org.myapp.softsquared_instagram.src.main.home.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse
import org.myapp.softsquared_instagram.src.main.search.models.ResultSearch

data class HomeFeedResponse(
    @SerializedName("result") val result : ResultHomeFeed
):BaseResponse()
