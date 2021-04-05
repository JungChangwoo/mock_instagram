package org.myapp.softsquared_instagram.src.main.home.comments.models

import com.google.gson.annotations.SerializedName

data class PostCommentRequest(
    @SerializedName("postIdx") val postIdx : Int,
    @SerializedName("content") val content : String
)
