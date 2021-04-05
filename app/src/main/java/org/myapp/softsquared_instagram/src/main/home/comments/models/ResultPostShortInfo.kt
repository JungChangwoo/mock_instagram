package org.myapp.softsquared_instagram.src.main.home.comments.models

import com.google.gson.annotations.SerializedName

data class ResultPostShortInfo(
    @SerializedName("nickName") val nickName : String,
    @SerializedName("profileImageUrl") val profileImageUrl : String,
    @SerializedName("postContent") val postContent : String
)
