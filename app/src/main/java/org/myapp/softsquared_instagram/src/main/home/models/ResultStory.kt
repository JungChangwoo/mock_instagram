package org.myapp.softsquared_instagram.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultStory(
    @SerializedName("nickName") val nickName : String,
    @SerializedName("profileImage") val profileImage : String
)
