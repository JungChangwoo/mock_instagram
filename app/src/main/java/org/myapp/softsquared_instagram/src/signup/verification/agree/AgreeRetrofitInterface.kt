package org.myapp.softsquared_instagram.src.signup.verification.agree

import retrofit2.Call
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.PostSignUpRequest
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.SignUpResponse
import retrofit2.http.*

interface AgreeRetrofitInterface {
    @POST("/users/join")
    fun PostSignUp(
        @Body params : PostSignUpRequest
    ) : Call<SignUpResponse>
}