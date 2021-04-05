package org.myapp.softsquared_instagram.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultPostInfo(
    @SerializedName("postIdx") val postIdx : Int,
    @SerializedName("nickName") val nickName : String,
    @SerializedName("profileImageUrl") val profileImageUrl : String,
    @SerializedName("content") val content : String,
    @SerializedName("where") val where : String,
    @SerializedName("numOfLike") val numOfLike : Int,
    @SerializedName("numOfComment") val numOfComment : Int,
    @SerializedName("isLiked") val isLiked : String
)
