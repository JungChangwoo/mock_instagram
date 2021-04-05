package org.myapp.softsquared_instagram.src.main.home

import org.myapp.softsquared_instagram.src.main.home.models.HomeFeedResponse
import org.myapp.softsquared_instagram.src.main.home.models.PostLikeResponse
import retrofit2.Call
import retrofit2.http.*

interface HomeRetrofitInterface {
    @GET("/posts/{userIdx}/main-feed")
    fun getHomeFeed(
        @Path("userIdx") userIdx : String,
        @Header("X-ACCESS-TOKEN") jwt : String
    ) : Call<HomeFeedResponse>

    @POST("/posts/{userIdx}/likes")
    fun postLike(
        @Path("userIdx") userIdx : String,
        @Header("X-ACCESS-TOKEN") jwt : String,
        @Body postIdx : Int
    ) : Call<PostLikeResponse>
}