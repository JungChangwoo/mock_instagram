package org.myapp.softsquared_instagram.src.main.upload

import org.myapp.softsquared_instagram.src.main.upload.models.UploadResponse

interface UploadActivityView {

    fun onPostUploadSuccess(response: UploadResponse)

    fun onPostUploadFailure(message:String)
}