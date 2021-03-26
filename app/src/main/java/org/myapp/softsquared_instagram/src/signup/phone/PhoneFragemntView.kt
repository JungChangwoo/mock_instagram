package org.myapp.softsquared_instagram.src.signup.phone

import org.myapp.softsquared_instagram.src.signup.phone.models.UserPhoneResponse

interface PhoneFragemntView {
    fun onGetPhoneUserSuccess(response : UserPhoneResponse)

    fun onGetPhoneUserFailure(message:String)
}