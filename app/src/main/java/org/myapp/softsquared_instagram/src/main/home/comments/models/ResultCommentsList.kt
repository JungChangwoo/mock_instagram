package org.myapp.softsquared_instagram.src.main.home.comments.models

import com.google.gson.annotations.SerializedName

data class ResultCommentsList(
    @SerializedName("commentIdx") val commentIdx : Int,
    @SerializedName("nickName") val nickName : String,
    @SerializedName("profileImageUrl") val profileImageUrl : String,
    @SerializedName("commentContent") val commentContent : String
)
