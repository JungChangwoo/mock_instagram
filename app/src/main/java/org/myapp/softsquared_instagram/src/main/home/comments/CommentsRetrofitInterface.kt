package org.myapp.softsquared_instagram.src.main.home.comments

import retrofit2.Call
import org.myapp.softsquared_instagram.src.main.home.comments.models.CommentsResponse
import org.myapp.softsquared_instagram.src.main.home.comments.models.PostCommentRequest
import org.myapp.softsquared_instagram.src.main.home.comments.models.PostCommentsResponse
import retrofit2.http.*

interface CommentsRetrofitInterface {
    @GET("/posts/{userIdx}/{postIdx}/comments")
    fun getComments(
        @Path("userIdx") userIdx : String,
        @Path("postIdx") postIdx : Int,
        @Header("X-ACCESS-TOKEN") jwt : String
    ):Call<CommentsResponse>

    @POST("/posts/{userIdx}/comments")
    fun postComments(
        @Path("userIdx") userIdx: String,
        @Header("X-ACCESS-TOKEN") jwt : String,
        @Body params : PostCommentRequest
    ): Call<PostCommentsResponse>
}