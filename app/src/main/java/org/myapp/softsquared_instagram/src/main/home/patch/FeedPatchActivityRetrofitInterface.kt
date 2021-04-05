package org.myapp.softsquared_instagram.src.main.home.patch

import org.myapp.softsquared_instagram.src.main.home.delete.models.FeedDeleteResponse
import org.myapp.softsquared_instagram.src.main.home.patch.models.FeedPatchResponse
import org.myapp.softsquared_instagram.src.main.home.patch.models.PatchFeedRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Path

interface FeedPatchActivityRetrofitInterface {
    @PATCH("/posts/{userIdx}")
    fun feedPatch(
        @Path("userIdx") userIdx : String,
        @Header("X-ACCESS-TOKEN") jwt : String,
        @Body params : PatchFeedRequest
    ) : Call<FeedPatchResponse>
}