package org.myapp.softsquared_instagram.src.main.home.delete

import org.myapp.softsquared_instagram.src.main.home.delete.models.FeedDeleteResponse

interface FeedDeleteDialogView {
    fun onPatchFeedDeleteSuccess(response : FeedDeleteResponse)

    fun onPatchFeedDeleteFailure(message : String)
}