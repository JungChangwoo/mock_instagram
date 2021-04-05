package org.myapp.softsquared_instagram.src.main.home.patch.models

import com.google.gson.annotations.SerializedName

data class ResultFeedPatch(
    @SerializedName("postIdx") val postIdx : Int
)
