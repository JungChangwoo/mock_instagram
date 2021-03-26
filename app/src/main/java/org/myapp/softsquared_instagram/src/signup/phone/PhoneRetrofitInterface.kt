package org.myapp.softsquared_instagram.src.signup.phone

import retrofit2.Call
import retrofit2.http.*
import org.myapp.softsquared_instagram.src.signup.phone.models.UserPhoneResponse

interface PhoneRetrofitInterface {
    @GET("/users/phoneNum?")
    fun getPhoneUsers(
        @Query("phoneNum") phoneNum : String
    ) : Call<UserPhoneResponse>
}