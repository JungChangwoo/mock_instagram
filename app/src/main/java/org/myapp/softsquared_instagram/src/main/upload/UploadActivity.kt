package org.myapp.softsquared_instagram.src.main.upload

import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityUploadBinding
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.home.HomeFragment

class UploadActivity:BaseActivity<ActivityUploadBinding>(ActivityUploadBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val postImageUrl = intent.getStringExtra("postImageUrl")
        val nickName = intent.getStringExtra("nickName")
        val userIdx = intent.getStringExtra("userIdx")
        val jwt = intent.getStringExtra("jwt")

        binding.activityUploadIvFeed.let { Glide.with(this).load(postImageUrl).into(it) }

        binding.activityUploadIvCheck.setOnClickListener {
            val content = binding.activityUploadEtContent.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nickName", nickName )
            intent.putExtra("userIdx", userIdx)
            intent.putExtra("jwt", jwt)
            intent.putExtra("postImageUrl", postImageUrl)
            intent.putExtra("content", content)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}