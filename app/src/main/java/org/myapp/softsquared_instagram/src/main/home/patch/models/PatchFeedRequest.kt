package org.myapp.softsquared_instagram.src.main.home.patch.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.src.main.home.models.PostImages

data class PatchFeedRequest(
    @SerializedName("postIdx") val postIdx: Int,
    @SerializedName("content") val content: String
)
