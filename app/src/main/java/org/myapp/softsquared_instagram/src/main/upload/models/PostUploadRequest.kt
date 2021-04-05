package org.myapp.softsquared_instagram.src.main.upload.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.src.main.home.models.PostImages

data class PostUploadRequest(
    @SerializedName("postImages") val postImages: ArrayList<PostImages>,
    @SerializedName("content") val content: String
)
