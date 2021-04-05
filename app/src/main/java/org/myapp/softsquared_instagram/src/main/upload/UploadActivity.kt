package org.myapp.softsquared_instagram.src.main.upload

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityUploadBinding
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.home.models.PostImages
import org.myapp.softsquared_instagram.src.main.upload.models.PostUploadRequest
import org.myapp.softsquared_instagram.src.main.upload.models.UploadResponse

class UploadActivity:BaseActivity<ActivityUploadBinding>(ActivityUploadBinding::inflate) ,UploadActivityView{

    private var nickName : String = ""
    private var userIdx : String = ""
    private var jwt : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val postImages = intent.getSerializableExtra("postImages") as ArrayList<PostImages>
        nickName = intent.getStringExtra("nickName").toString()
        userIdx = intent.getStringExtra("userIdx").toString()
        jwt = intent.getStringExtra("jwt").toString()

        Log.d("dddddddddddddddddddddd",postImages[0].toString())
        Log.d("ddddddddddddddddddddd", postImages.toString())
        val firstPostUrl = postImages[0].url.toString()
        binding.activityUploadIvFeed.let { Glide.with(this).load(firstPostUrl).into(it) }

        binding.activityUploadIvCheck.setOnClickListener {
            val content = binding.activityUploadEtContent.text.toString()

            val postUploadRequest = PostUploadRequest(postImages = postImages , content = content )
            UploadService(this).postUploadFeed(userIdx!!, jwt!!,postUploadRequest)
        }
    }

    override fun onPostUploadSuccess(response: UploadResponse) {
        showCustomToast("업로드 성공")
        val intentUpload = Intent(this, MainActivity::class.java)
        intentUpload.putExtra("nickName",nickName)
        intentUpload.putExtra("userIdx",userIdx)
        intentUpload.putExtra("jwt",jwt)
        intentUpload.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentUpload)
    }

    override fun onPostUploadFailure(message: String) {

    }
}