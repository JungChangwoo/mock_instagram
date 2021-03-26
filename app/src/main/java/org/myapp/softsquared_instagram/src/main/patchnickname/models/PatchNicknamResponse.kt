package org.myapp.softsquared_instagram.src.main.patchnickname.models

import com.google.gson.annotations.SerializedName
import org.myapp.softsquared_instagram.config.BaseResponse

data class PatchNicknamResponse(
    @SerializedName("result") val result : String
) : BaseResponse()
