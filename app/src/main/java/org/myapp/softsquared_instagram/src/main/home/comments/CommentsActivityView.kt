package org.myapp.softsquared_instagram.src.main.home.comments

import org.myapp.softsquared_instagram.src.main.home.comments.models.CommentsResponse
import org.myapp.softsquared_instagram.src.main.home.comments.models.PostCommentsResponse

interface CommentsActivityView {

    fun onGetCommentsSuccess(response:CommentsResponse)

    fun onGetCommentsFailure(message : String)

    fun onPostCommentSuccess(response: PostCommentsResponse)

    fun onPostCommentFailure(message: String)
}