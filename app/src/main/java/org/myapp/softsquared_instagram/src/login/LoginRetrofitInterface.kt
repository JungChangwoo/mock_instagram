package org.myapp.softsquared_instagram.src.login

import org.myapp.softsquared_instagram.src.login.models.LoginResponse
import org.myapp.softsquared_instagram.src.login.models.PostLoginRequest
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.PostSignUpRequest
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {
    @POST("/users/login")
    fun PostLogin(@Body params : PostLoginRequest) : Call<LoginResponse>
}