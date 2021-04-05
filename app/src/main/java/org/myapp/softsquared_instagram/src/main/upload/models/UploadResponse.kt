package org.myapp.softsquared_instagram.src.main.upload.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse

data class UploadResponse(
    @SerializedName("result") val result: ResultUpload
) : BaseResponse()