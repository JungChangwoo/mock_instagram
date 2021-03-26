package org.myapp.softsquared_instagram.src.main.patchnickname

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.main.mypage.MypageFragmentView
import org.myapp.softsquared_instagram.src.main.patchnickname.models.PatchNicknamResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class PatchNicknameService (val view : PatchNicknameView){

    fun tryPatchNickname(userIdx : String, jwt:String, nickName:String){
        val nicknameRetrofitInterface = ApplicationClass.sRetrofit.create(PatchNicknameRetrofitInterface::class.java)
        nicknameRetrofitInterface.patchNickname(userIdx,jwt,nickName).enqueue(object : Callback<PatchNicknamResponse>{
            override fun onResponse(
                call: Call<PatchNicknamResponse>,
                response: Response<PatchNicknamResponse>
            ) {
                view.onPatchNicknameSuccess(response.body() as PatchNicknamResponse)
            }

            override fun onFailure(call: Call<PatchNicknamResponse>, t: Throwable) {
                view.onPatchNicknameFailuer(t.message ?: "통신 오류")
            }

        })
    }
}