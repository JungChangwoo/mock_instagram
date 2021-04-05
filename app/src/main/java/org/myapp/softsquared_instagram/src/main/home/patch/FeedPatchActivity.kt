package org.myapp.softsquared_instagram.src.main.home.patch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.config.BaseFragment
import org.myapp.softsquared_instagram.databinding.ActivityFeedPatchBinding
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.home.patch.models.FeedPatchResponse
import org.myapp.softsquared_instagram.src.main.home.patch.models.PatchFeedRequest

class FeedPatchActivity : BaseActivity<ActivityFeedPatchBinding>(ActivityFeedPatchBinding::inflate), FeedPatchActivityView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val postIdx = intent.getStringExtra("postIdx").toString()
        val content = intent.getStringExtra("content").toString()
        val nickName = intent.getStringExtra("nickName")
        val feedImageUrl = intent.getStringExtra("feedImageUrl")
        val userIdx = intent.getStringExtra("userIdx").toString()
        val jwt = intent.getStringExtra("jwt").toString()
        Log.d("ddddddddddddd", postIdx+" "+userIdx+" "+jwt)

        binding.fragmentFeedPatchTvNickName.text = nickName
        binding.fragmentFeedPatchEtContent.setText(content)

        if(feedImageUrl!!.isNotEmpty()){
            binding.fragmentFeedPatchIvFeed?.let { Glide.with(this).load(feedImageUrl).into(it) }
        }



        binding.fragmentFeedPatchEtContent.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.fragmentFeedPatchIvCheck.setImageResource(R.drawable.instagram_check)
                binding.fragmentFeedPatchIvCheck.isClickable
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })

        //check버튼 누르면 patch api실행
        binding.fragmentFeedPatchIvCheck.setOnClickListener {
            val patchContent = binding.fragmentFeedPatchEtContent.text.toString()
            val patchFeedRequest = PatchFeedRequest(postIdx = postIdx.toInt(), content = patchContent)
            FeedPatchService(this).tryPatchFeedPatch(userIdx!!,jwt!!,patchFeedRequest)
        }



    }

    override fun onPatchFeedSuccess(response: FeedPatchResponse) {
        finish()
        showCustomToast("피드가 수정되었습니다.")
    }

    override fun onPatchFeedFailure(message: String) {

    }
}



