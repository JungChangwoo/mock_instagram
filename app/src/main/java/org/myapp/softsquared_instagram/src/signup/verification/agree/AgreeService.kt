package org.myapp.softsquared_instagram.src.signup.verification.agree

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.PostSignUpRequest
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AgreeService(val view:AgreeActivityView) {

    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
        val agreeRetrofitInterface = ApplicationClass.sRetrofit.create(AgreeRetrofitInterface::class.java)
        agreeRetrofitInterface.PostSignUp(postSignUpRequest).enqueue(object : Callback<SignUpResponse>{
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                view.onPostSignUpSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                view.onPostSignUpFailure(t.message ?: "통신 오류")
            }
        })
    }
}