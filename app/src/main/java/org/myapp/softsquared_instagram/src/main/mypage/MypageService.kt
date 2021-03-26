package org.myapp.softsquared_instagram.src.main.mypage

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.main.mypage.models.FollowingResponse
import org.myapp.softsquared_instagram.src.main.mypage.models.MypageResponse
import org.myapp.softsquared_instagram.src.main.mypage.models.PostFollowingRequest
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.PostSignUpRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MypageService(val view:MypageFragmentView) {

    fun tryGetMypageUsers(nickName : String, jwt: String, userIdx : String){
        val mypageRetrofitInterface = ApplicationClass.sRetrofit.create(MypageRetrofitInterface::class.java)
        mypageRetrofitInterface.getMypageUsers(userIdx,jwt, nickName).enqueue(object : Callback<MypageResponse>{
            override fun onResponse(
                call: Call<MypageResponse>,
                response: Response<MypageResponse>
            ) {
                view.onGetMypageUserSuccess(response.body() as MypageResponse)
            }

            override fun onFailure(call: Call<MypageResponse>, t: Throwable) {
                view.onGetMypageUserFailure(t.message ?: "통신 오류")
            }

        })
    }

    fun tryPostFollowing(userIdx:String, jwt : String,postFollowingRequest : PostFollowingRequest){
        val mypageRetrofitInterface = ApplicationClass.sRetrofit.create(MypageRetrofitInterface::class.java)
        mypageRetrofitInterface.postMypageFollowing(userIdx,jwt,postFollowingRequest).enqueue(object : Callback<FollowingResponse>{
            override fun onResponse(
                call: Call<FollowingResponse>,
                response: Response<FollowingResponse>
            ) {
                view.onGetFollowingSuccess(response.body() as FollowingResponse)
            }

            override fun onFailure(call: Call<FollowingResponse>, t: Throwable) {
                view.onGetFollowingFailure(t.message ?: "통신 오류")
            }

        })
    }
}