package org.myapp.softsquared_instagram.src.signup.email

import org.myapp.softsquared_instagram.src.signup.email.models.UserEmailResponse

interface EmailFragmentView {
    fun onGetEmailUserSuccess(response: UserEmailResponse)

    fun onGetEmailUserFailure(message:String)
}