package org.myapp.softsquared_instagram.src.main.home.patch.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse

data class FeedPatchResponse(
    @SerializedName("result") val result : ResultFeedPatch
):BaseResponse()
