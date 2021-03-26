package org.myapp.softsquared_instagram.src.main.mypage.models

import com.google.gson.annotations.SerializedName

data class ResultMypage(
    @SerializedName("userInfo") val userInfo : ResultUserInfo,
    @SerializedName("post") val post : ArrayList<ResultPost>
)
