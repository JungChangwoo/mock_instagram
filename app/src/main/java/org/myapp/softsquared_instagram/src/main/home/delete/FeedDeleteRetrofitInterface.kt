package org.myapp.softsquared_instagram.src.main.home.delete

import org.myapp.softsquared_instagram.src.main.home.delete.models.FeedDeleteResponse
import org.myapp.softsquared_instagram.src.main.patchnickname.models.PatchNicknamResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Path

interface FeedDeleteRetrofitInterface {
    @PATCH("/posts/{userIdx}/status")
    fun feedDelete(
        @Path("userIdx") userIdx : String,
        @Header("X-ACCESS-TOKEN") jwt : String,
        @Body postIdx : Int
    ) : Call<FeedDeleteResponse>
}