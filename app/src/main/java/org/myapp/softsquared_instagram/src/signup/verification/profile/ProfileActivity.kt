package org.myapp.softsquared_instagram.src.signup.verification.profile

import android.content.Intent
import android.os.Bundle
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityVerificationProfileBinding
import org.myapp.softsquared_instagram.src.signup.verification.private.PrivateActivity

class ProfileActivity:BaseActivity<ActivityVerificationProfileBinding>(ActivityVerificationProfileBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nickName = intent.getStringExtra("nickName")
        val password = intent.getStringExtra("password")

        binding.activityProfileTvPass.setOnClickListener {
            var intentProfile = Intent(this, PrivateActivity::class.java)
            intentProfile.putExtra("nickName", nickName)
            intentProfile.putExtra("password",password)
            startActivity(intentProfile)
        }
    }
}