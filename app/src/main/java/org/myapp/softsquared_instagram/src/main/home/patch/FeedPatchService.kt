package org.myapp.softsquared_instagram.src.main.home.patch

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.main.home.patch.models.FeedPatchResponse
import org.myapp.softsquared_instagram.src.main.home.patch.models.PatchFeedRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedPatchService(val view:FeedPatchActivityView) {

    fun tryPatchFeedPatch(userIdx:String, jwt:String, patchFeedRequest: PatchFeedRequest) {
        val feedPatchRetrofitInterface = ApplicationClass.sRetrofit.create(FeedPatchActivityRetrofitInterface::class.java)
        feedPatchRetrofitInterface.feedPatch(userIdx,jwt,patchFeedRequest).enqueue(object : Callback<FeedPatchResponse>{
            override fun onResponse(
                call: Call<FeedPatchResponse>,
                response: Response<FeedPatchResponse>
            ) {
                view.onPatchFeedSuccess(response.body() as FeedPatchResponse)
            }
            override fun onFailure(call: Call<FeedPatchResponse>, t: Throwable) {
                view.onPatchFeedFailure(t.message ?: "통신 오류")
            }

        })
    }
}