package org.myapp.softsquared_instagram.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultPost(
    @SerializedName("postInfo") val postInfo : ResultPostInfo,
    @SerializedName("postImages") val postImages : ArrayList<ResultPostImages>,
    @SerializedName("postTags") val postTags : ArrayList<ResultPostTags>
)
