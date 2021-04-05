package org.myapp.softsquared_instagram.src.main.home.comments

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.main.home.comments.models.CommentsResponse
import org.myapp.softsquared_instagram.src.main.home.comments.models.PostCommentRequest
import org.myapp.softsquared_instagram.src.main.home.comments.models.PostCommentsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CommentsService(val view : CommentsActivityView) {

    fun tryGetComments(userIdx:String, postIdx:Int, jwt : String){
        val commentsRetrofitInterface = ApplicationClass.sRetrofit.create(CommentsRetrofitInterface::class.java)
        commentsRetrofitInterface.getComments(userIdx, postIdx, jwt).enqueue(object : Callback<CommentsResponse>{
            override fun onResponse(
                call: Call<CommentsResponse>,
                response: Response<CommentsResponse>
            ) {
                view.onGetCommentsSuccess(response.body() as CommentsResponse)
            }

            override fun onFailure(call: Call<CommentsResponse>, t: Throwable) {
                view.onGetCommentsFailure(t.message ?: "통신 오류")
            }

        })
    }

    fun tryPostComment(userIdx: String,jwt: String, postCommentRequest: PostCommentRequest){
        val commentRetrofitInterface = ApplicationClass.sRetrofit.create(CommentsRetrofitInterface::class.java)
        commentRetrofitInterface.postComments(userIdx,jwt,postCommentRequest).enqueue(object : Callback<PostCommentsResponse>{
            override fun onResponse(call: Call<PostCommentsResponse>, response: Response<PostCommentsResponse>
            ) {
                view.onPostCommentSuccess(response.body() as PostCommentsResponse)
            }

            override fun onFailure(call: Call<PostCommentsResponse>, t: Throwable) {
                view.onPostCommentFailure(t.message ?: "통신 오류")
            }

        })
    }
}