package org.myapp.softsquared_instagram.src.main.patchnickname

import org.myapp.softsquared_instagram.src.main.patchnickname.models.PatchNicknamResponse

interface PatchNicknameView {

    fun onPatchNicknameSuccess(response : PatchNicknamResponse)

    fun onPatchNicknameFailuer(message : String)
}