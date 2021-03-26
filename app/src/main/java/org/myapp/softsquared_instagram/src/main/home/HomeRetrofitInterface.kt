package org.myapp.softsquared_instagram.src.main.home

import org.myapp.softsquared_instagram.src.main.home.models.HomeFeedResponse
import org.myapp.softsquared_instagram.src.main.home.models.PostUploadRequest
import org.myapp.softsquared_instagram.src.main.home.models.UploadResponse
import org.myapp.softsquared_instagram.src.main.search.models.UserSearchResponse
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.PostSignUpRequest
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface HomeRetrofitInterface {
    @GET("/posts/{userIdx}/main-feed")
    fun getHomeFeed(
        @Path("userIdx") userIdx : String,
        @Header("X-ACCESS-TOKEN") jwt : String
    ) : Call<HomeFeedResponse>

    @POST("/posts/{userIdx}")
    fun UploadFeed(
        @Path("userIdx") userIdx: String,
        @Header("X-ACCESS-TOKEN") wt : String,
        @Body params : PostUploadRequest
    ) : Call<UploadResponse>
}