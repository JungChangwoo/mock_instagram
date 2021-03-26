package org.myapp.softsquared_instagram.src.signup.phone

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.signup.email.EmailFragment
import org.myapp.softsquared_instagram.src.signup.phone.models.UserPhoneResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PhoneService(val view: PhoneFragment){

    fun tryGetPhoneUsers(phoneNum : String){
        val phoneRetrofitInterface = ApplicationClass.sRetrofit.create(PhoneRetrofitInterface::class.java)
        phoneRetrofitInterface.getPhoneUsers(phoneNum).enqueue(object : Callback<UserPhoneResponse>{
            override fun onResponse(call: Call<UserPhoneResponse>, response: Response<UserPhoneResponse>) {
                view.onGetPhoneUserSuccess(response.body() as UserPhoneResponse)
            }

            override fun onFailure(call: Call<UserPhoneResponse>, t: Throwable) {
                view.onGetPhoneUserFailure(t.message ?: "통신 오류")
            }
        })
    }
}