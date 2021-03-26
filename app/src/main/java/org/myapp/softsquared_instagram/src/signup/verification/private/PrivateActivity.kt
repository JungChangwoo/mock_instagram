package org.myapp.softsquared_instagram.src.signup.verification.private

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityVerificationPrivteBinding
import org.myapp.softsquared_instagram.src.login.LoginActivity
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.signup.verification.profile.ProfileActivity

class PrivateActivity:BaseActivity<ActivityVerificationPrivteBinding>(ActivityVerificationPrivteBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nickName = intent.getStringExtra("nickName")
        val password = intent.getStringExtra("password")

        //버튼 상태에 따른 체크
        binding.activityPrivateCheckboxLock.setOnClickListener { onCheckChanged(binding.activityPrivateCheckboxLock) }
        binding.activityPrivateCheckboxUnlock.setOnClickListener { onCheckChanged(binding.activityPrivateCheckboxUnlock) }

        binding.activityPrivateBtnNext.setOnClickListener {

            var intentPrivate = Intent(this, LoginActivity::class.java)
            intentPrivate.putExtra("nickName",nickName)
            intentPrivate.putExtra("password", password)
            intentPrivate.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intentPrivate)
        }
    }
    //하나만 선택 가능함.
    private fun onCheckChanged(checkbox: CheckBox) {
        when (checkbox.id) {
            R.id.activity_private_checkbox_lock -> {
                if(binding.activityPrivateCheckboxLock.isChecked){
                    binding.activityPrivateCheckboxUnlock.isChecked = false
                    binding.activityPrivateBtnNext.setBackgroundResource(R.drawable.login_login_btn_background)
                    binding.activityPrivateBtnNext.isClickable = true
                    binding.activityPrivateBtnNext.isEnabled = true
                } else{
                    if(!binding.activityPrivateCheckboxUnlock.isChecked){
                        binding.activityPrivateBtnNext.setBackgroundResource(R.drawable.unactive_facebook_color_btn)
                        binding.activityPrivateBtnNext.isClickable = false
                        binding.activityPrivateBtnNext.isEnabled = false
                    }
                }
            }
            R.id.activity_private_checkbox_unlock -> {
                if (binding.activityPrivateCheckboxUnlock.isChecked) {
                    binding.activityPrivateCheckboxLock.isChecked = false
                    binding.activityPrivateBtnNext.setBackgroundResource(R.drawable.login_login_btn_background)
                    binding.activityPrivateBtnNext.isClickable = true
                    binding.activityPrivateBtnNext.isEnabled = true
                } else {
                    if (!binding.activityPrivateCheckboxLock.isChecked) {
                        binding.activityPrivateBtnNext.setBackgroundResource(R.drawable.unactive_facebook_color_btn)
                        binding.activityPrivateBtnNext.isClickable = false
                        binding.activityPrivateBtnNext.isEnabled = false
                    }
                }
            }
        }
    }
}