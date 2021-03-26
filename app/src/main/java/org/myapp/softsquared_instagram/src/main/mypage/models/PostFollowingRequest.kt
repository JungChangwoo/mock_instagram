package org.myapp.softsquared_instagram.src.main.mypage.models

import com.google.gson.annotations.SerializedName

data class PostFollowingRequest(
    @SerializedName("followingNickName") val followingNickName : String
)
