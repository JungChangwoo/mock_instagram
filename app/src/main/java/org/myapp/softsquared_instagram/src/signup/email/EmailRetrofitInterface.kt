package org.myapp.softsquared_instagram.src.signup.email

import org.myapp.softsquared_instagram.src.signup.email.models.UserEmailResponse
import org.myapp.softsquared_instagram.src.signup.phone.models.UserPhoneResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EmailRetrofitInterface {

    @GET("/users/email?")
    fun getEmailUsers(
        @Query("email") email : String
    ) : Call<UserEmailResponse>
}