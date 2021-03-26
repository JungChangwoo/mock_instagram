package org.myapp.softsquared_instagram.src.main.patchnickname

import org.myapp.softsquared_instagram.src.main.mypage.models.FollowingResponse
import org.myapp.softsquared_instagram.src.main.mypage.models.PostFollowingRequest
import org.myapp.softsquared_instagram.src.main.patchnickname.models.PatchNicknamResponse
import retrofit2.Call
import retrofit2.http.*

interface PatchNicknameRetrofitInterface {
    @PATCH("/users/{userIdx}/nickName")
    fun patchNickname(
        @Path("userIdx") userIdx : String,
        @Header("X-ACCESS-TOKEN") jwt : String,
        @Body nickName : String
    ) : Call<PatchNicknamResponse>
}