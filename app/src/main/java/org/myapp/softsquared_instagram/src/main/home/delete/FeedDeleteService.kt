package org.myapp.softsquared_instagram.src.main.home.delete

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.main.home.delete.models.FeedDeleteResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class FeedDeleteService(val view: FeedDeleteDialogView) {

    fun tryPatchFeedDelete(userIdx:String, jwt:String, postIdx : Int){
        val feedDeleteRetrofitInterface = ApplicationClass.sRetrofit.create(FeedDeleteRetrofitInterface::class.java)
        feedDeleteRetrofitInterface.feedDelete(userIdx, jwt, postIdx).enqueue(object : Callback<FeedDeleteResponse>{
            override fun onResponse(
                call: Call<FeedDeleteResponse>,
                response: Response<FeedDeleteResponse>
            ) {
                view.onPatchFeedDeleteSuccess(response.body() as FeedDeleteResponse)
            }

            override fun onFailure(call: Call<FeedDeleteResponse>, t: Throwable) {
                view.onPatchFeedDeleteFailure(t.message ?: "통신 오류")
            }

        })
    }
}