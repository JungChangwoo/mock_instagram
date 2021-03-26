package org.myapp.softsquared_instagram.src.main.home

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.main.home.models.HomeFeedResponse
import org.myapp.softsquared_instagram.src.main.home.models.PostUploadRequest
import org.myapp.softsquared_instagram.src.main.home.models.UploadResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class HomeService(val view : HomeFragmentView) {

    fun tryGetHomeFeed(userIdx:String,jwt : String){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getHomeFeed(userIdx,jwt).enqueue(object : Callback<HomeFeedResponse>{
            override fun onResponse(call: Call<HomeFeedResponse>, response: Response<HomeFeedResponse>
            ) {
                view.onGetHomeFeedSuccess(response.body() as HomeFeedResponse)
            }

            override fun onFailure(call: Call<HomeFeedResponse>, t: Throwable) {
                view.onGetHomeFeedFailure(t.message ?: "통신 오류")
            }

        })
    }

    fun postUploadFeed(userIdx:String, jwt : String, postUploadFeed : PostUploadRequest) {
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.UploadFeed(userIdx,jwt,postUploadFeed).enqueue(object : Callback<UploadResponse>{
            override fun onResponse(call: Call<UploadResponse>, response: Response<UploadResponse>
            ) {
                view.onPostUploadSuccess(response.body() as UploadResponse)
            }

            override fun onFailure(call: Call<UploadResponse>, t: Throwable) {
                view.onPostUploadFailure(t.message ?: "통신 오류")
            }

        })
    }

}