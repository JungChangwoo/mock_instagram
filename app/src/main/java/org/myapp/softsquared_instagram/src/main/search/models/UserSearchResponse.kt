package org.myapp.softsquared_instagram.src.main.search.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse

data class UserSearchResponse(
    @SerializedName("result") val result : ArrayList<ResultSearch>
):BaseResponse()
