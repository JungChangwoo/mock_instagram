package org.myapp.softsquared_instagram.src.main.home

import org.myapp.softsquared_instagram.src.main.home.models.HomeFeedResponse
import org.myapp.softsquared_instagram.src.main.home.models.UploadResponse
import org.myapp.softsquared_instagram.src.main.search.models.UserSearchResponse

interface HomeFragmentView {
    fun onGetHomeFeedSuccess(response: HomeFeedResponse)

    fun onGetHomeFeedFailure(message:String)

    fun onPostUploadSuccess(response: UploadResponse)

    fun onPostUploadFailure(message:String)
}