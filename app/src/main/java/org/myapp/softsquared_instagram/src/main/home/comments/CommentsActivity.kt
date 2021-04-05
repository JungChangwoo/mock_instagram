package org.myapp.softsquared_instagram.src.main.home.comments

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityCommentsBinding
import org.myapp.softsquared_instagram.src.main.home.comments.models.*

class CommentsActivity:BaseActivity<ActivityCommentsBinding>(ActivityCommentsBinding::inflate), CommentsActivityView {

    lateinit var userIdx : String
    lateinit var jwt : String
    var postIdx : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userIdx = intent.getStringExtra("userIdx").toString()
        jwt = intent.getStringExtra("jwt").toString()
        postIdx = intent.getStringExtra("postIdx")!!.toInt()

        Log.d("ddddddddddddddddddd",userIdx+" "+jwt+" "+postIdx)

        showLoadingDialog(this)
        CommentsService(this).tryGetComments(userIdx, postIdx, jwt)

        binding.activityCommentsIvCommentWriterContent.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.activityCommentsIvCommentWriterContent.length()==0){
                    binding.activityCommentsTvCommentWriterPost.setTextColor(Color.parseColor("#cdf0ff"))
                } else{
                    binding.activityCommentsTvCommentWriterPost.setTextColor(Color.parseColor("#0195f7"))
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.activityCommentsTvCommentWriterPost.setOnClickListener {
            val content = binding.activityCommentsIvCommentWriterContent.text.toString()
            val postCommentRequest = PostCommentRequest(postIdx, content)
            CommentsService(this).tryPostComment(userIdx, jwt, postCommentRequest)
        }

    }

    private fun setWriterInfo(postShortInfo: ResultPostShortInfo){
        binding.activityCommentsTvWriterNickName.text = postShortInfo.nickName
        binding.activityCommentsTvWriterContent.text = postShortInfo.postContent
        //val writerProfileUrl = postShortInfo.profileImageUrl
        //binding.activityCommentsIvWriterProfile.let {Glide.with(this).load(writerProfileUrl).into(it)}
        binding.activityCommentsIvWriterProfile.setImageResource(R.drawable.instagram_mypage)
    }

    private fun setCommentsAdapter(comments: ArrayList<ResultCommentsList>){
        val commentsAdapter = CommentsRecyclerAdapter(this,comments)
        binding.activityCommentsRecyclerview.adapter = commentsAdapter
        binding.activityCommentsRecyclerview.layoutManager = LinearLayoutManager(this)
    }

    override fun onGetCommentsSuccess(response: CommentsResponse) {
        dismissLoadingDialog()
        setWriterInfo(response.result.postShortInfo)
        setCommentsAdapter(response.result.comments)
        showCustomToast("댓글창 get 성공")
    }

    override fun onGetCommentsFailure(message: String) {
        TODO("Not yet implemented")
    }

    //댓글 작성
    override fun onPostCommentSuccess(response: PostCommentsResponse) {
        showCustomToast("댓글 작성 성공")
    }

    override fun onPostCommentFailure(message: String) {
        TODO("Not yet implemented")
    }
}