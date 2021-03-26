package org.myapp.softsquared_instagram.src.main.home.models

import com.google.gson.annotations.SerializedName

data class PostUploadRequest(
    @SerializedName("postImages") val postImages: ArrayList<PostImages>,
    @SerializedName("content") val content: String
)