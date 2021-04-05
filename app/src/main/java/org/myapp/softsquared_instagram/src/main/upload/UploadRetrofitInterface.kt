package org.myapp.softsquared_instagram.src.main.upload

import org.myapp.softsquared_instagram.src.main.upload.models.PostUploadRequest
import org.myapp.softsquared_instagram.src.main.upload.models.UploadResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface UploadRetrofitInterface {

    @POST("/posts/{userIdx}")
    fun uploadFeed(
        @Path("userIdx") userIdx: String,
        @Header("X-ACCESS-TOKEN") jwt : String,
        @Body params : PostUploadRequest
    ) : Call<UploadResponse>
}