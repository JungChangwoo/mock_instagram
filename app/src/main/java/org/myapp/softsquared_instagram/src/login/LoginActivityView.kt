package org.myapp.softsquared_instagram.src.login

import org.myapp.softsquared_instagram.src.login.models.LoginResponse

interface LoginActivityView {
    fun onPostLoginSuccess(response: LoginResponse, nickName: String)

    fun onPostLoginFailure(message : String)
}