package org.myapp.softsquared_instagram.src.signup.verification.serach

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityVerificationSerachFriendsBinding

class SearchFacebookActivity:BaseActivity<ActivityVerificationSerachFriendsBinding>(ActivityVerificationSerachFriendsBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nickName = intent.getStringExtra("nickName")
        val password = intent.getStringExtra("password")

        val layoutInflater : LayoutInflater = LayoutInflater.from(this)
        val passDialogView = layoutInflater.inflate(R.layout.dialog_search_pass, null)
        binding.activityFriendsTvPass.setOnClickListener {
            val serachDialog = SearchFacebookCustomDialog(nickName,password)
            serachDialog.show(supportFragmentManager,"건너뛰기")
            val searchPass = passDialogView.findViewById<TextView>(R.id.dialog_search_pass_tv_pass)

        }
    }
}