package org.myapp.softsquared_instagram.src.signup.email

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.signup.email.models.UserEmailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmailService (val view: EmailFragmentView) {

    fun tryGetEmailUsers(email : String){
        val emailRetrofitInterface = ApplicationClass.sRetrofit.create(EmailRetrofitInterface::class.java)
        emailRetrofitInterface.getEmailUsers(email).enqueue(object : Callback<UserEmailResponse> {
            override fun onResponse(call: Call<UserEmailResponse>, response: Response<UserEmailResponse>) {
                view.onGetEmailUserSuccess(response.body() as UserEmailResponse)
            }

            override fun onFailure(call: Call<UserEmailResponse>, t: Throwable) {
                view.onGetEmailUserFailure(t.message ?: "통신 오류")
            }
        })
    }
}