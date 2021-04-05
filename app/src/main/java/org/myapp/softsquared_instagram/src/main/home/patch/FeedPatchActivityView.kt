package org.myapp.softsquared_instagram.src.main.home.patch

import org.myapp.softsquared_instagram.src.main.home.patch.models.FeedPatchResponse

interface FeedPatchActivityView {

    fun onPatchFeedSuccess(response:FeedPatchResponse)

    fun onPatchFeedFailure(message : String)
}