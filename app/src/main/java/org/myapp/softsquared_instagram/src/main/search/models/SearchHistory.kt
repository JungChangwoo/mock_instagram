package org.myapp.softsquared_instagram.src.main.search.models

import com.google.gson.annotations.SerializedName

data class SearchHistory(
    @SerializedName("profileImageUrl") val profileImageUrl : String,
    @SerializedName("nickName") val nickName : String,
    @SerializedName("name") val name : String
)
