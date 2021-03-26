package org.myapp.softsquared_instagram.src.signup.verification.agree

import org.myapp.softsquared_instagram.src.signup.verification.agree.models.SignUpResponse

interface AgreeActivityView {
    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message : String)
}