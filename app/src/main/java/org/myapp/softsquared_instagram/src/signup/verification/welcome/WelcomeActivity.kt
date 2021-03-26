package org.myapp.softsquared_instagram.src.signup.verification.welcome

import android.content.Intent
import android.os.Bundle
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityVerificationWelcomeBinding
import org.myapp.softsquared_instagram.src.signup.verification.serach.SearchFacebookActivity

class WelcomeActivity:BaseActivity<ActivityVerificationWelcomeBinding>(ActivityVerificationWelcomeBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nickName = intent.getStringExtra("nickName").toString()
        val password = intent.getStringExtra("password").toString()

        binding.activityWelcomeTvNickname.text = nickName

        binding.activityWelcomeBtnNext.setOnClickListener {
            var intentWelcome = Intent(this, SearchFacebookActivity::class.java)
            intentWelcome.putExtra("nickName", nickName)
            intentWelcome.putExtra("password",password)
            startActivity(intentWelcome)
        }
    }
}