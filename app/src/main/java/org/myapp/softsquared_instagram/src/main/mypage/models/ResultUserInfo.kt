package org.myapp.softsquared_instagram.src.main.mypage.models

import com.google.gson.annotations.SerializedName

data class ResultUserInfo(
    @SerializedName("nickName") val nickName : String,
    @SerializedName("profileImageUrl") val profileImageUrl : String,
    @SerializedName("numOfPost") val numOfPost : Int,
    @SerializedName("follower") val follower : Int,
    @SerializedName("following") val following : Int,
    @SerializedName("name") val name : String,
    @SerializedName("isFollowed") val isFollowed : String
)
