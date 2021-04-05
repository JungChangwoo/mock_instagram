package org.myapp.softsquared_instagram.src.main.home.comments.models

import com.google.gson.annotations.SerializedName

data class ResultComments(
    @SerializedName("postShortInfo") val postShortInfo : ResultPostShortInfo,
    @SerializedName("comments") val comments : ArrayList<ResultCommentsList>
)
