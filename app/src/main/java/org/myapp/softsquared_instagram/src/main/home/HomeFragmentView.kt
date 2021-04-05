package org.myapp.softsquared_instagram.src.main.home

import org.myapp.softsquared_instagram.src.main.home.models.HomeFeedResponse
import org.myapp.softsquared_instagram.src.main.home.models.PostLikeResponse

interface HomeFragmentView {
    fun onGetHomeFeedSuccess(response: HomeFeedResponse)

    fun onGetHomeFeedFailure(message:String)

    fun onPostLikeSuccess(response : PostLikeResponse)

    fun onPostLikeFailure(message: String)
}