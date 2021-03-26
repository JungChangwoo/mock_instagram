package org.myapp.softsquared_instagram.src.main.home.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.src.main.mypage.models.ResultUserInfo

data class ResultHomeFeed(
    @SerializedName("story") val story : ArrayList<ResultStory>,
    @SerializedName("post") val post : ArrayList<ResultPost>
)
