package org.myapp.softsquared_instagram.src.main.home

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.main.home.models.HomeFeedResponse
import org.myapp.softsquared_instagram.src.main.home.models.PostLikeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

    fun tryPostLike(userIdx: String, jwt: String, postIdx:Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.postLike(userIdx,jwt, postIdx).enqueue(object : Callback<PostLikeResponse>{
            override fun onResponse(
                call: Call<PostLikeResponse>,
                response: Response<PostLikeResponse>
            ) {
                view.onPostLikeSuccess(response.body() as PostLikeResponse)
            }

            override fun onFailure(call: Call<PostLikeResponse>, t: Throwable) {
                view.onPostLikeFailure(t.message ?: "통신 오류")
            }

        })
    }

}