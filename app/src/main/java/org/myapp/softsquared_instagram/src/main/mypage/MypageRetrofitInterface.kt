package org.myapp.softsquared_instagram.src.main.mypage

import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.mypage.models.FollowingResponse
import org.myapp.softsquared_instagram.src.main.mypage.models.MypageResponse
import org.myapp.softsquared_instagram.src.main.mypage.models.PostFollowingRequest
import org.myapp.softsquared_instagram.src.main.search.models.UserSearchResponse
import retrofit2.Call
import retrofit2.http.*

interface MypageRetrofitInterface {

    //           +변수+ 가 들어가야 함함
    @GET("/users/{userIdx}/my-page?")
    fun getMypageUsers(
        @Path("userIdx") userIdx: String,
        @Header("X-ACCESS-TOKEN") jwt: String,
        @Query("nickName") nickName: String
    ): Call<MypageResponse>

    @POST("/users/{userIdx}/following")
    fun postMypageFollowing(
        @Path("userIdx") userIdx: String,
        @Header("X-ACCESS-TOKEN") jwt: String,
        @Body params: PostFollowingRequest
    ): Call<FollowingResponse>

    @PATCH("/users/{userIdx}/following/status")
    fun patchMypageUnfollow(
        @Path("userIdx") userIdx: String,
        @Header("X-ACCESS-TOKEN") jwt: String,
        @Body params: PostFollowingRequest
    ): Call<FollowingResponse>


}