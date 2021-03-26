package org.myapp.softsquared_instagram.src.main.patchnickname

import android.os.Bundle
import okio.blackholeSink
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityPatchNicknameBinding
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.patchnickname.models.PatchNicknamResponse

class PatchNickname : BaseActivity<ActivityPatchNicknameBinding>(ActivityPatchNicknameBinding::inflate),
    PatchNicknameView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nickname = intent.getStringExtra("nickName").toString()
        val name = intent.getStringExtra("name").toString()
        val userIdx = intent.getStringExtra("userIdx").toString()
        val jwt = intent.getStringExtra("jwt").toString()


        binding.activityPatchNickNameEtName.setText(name)
        binding.activityPatchNickNameEtNickname.setText(nickname)

        binding.activityPatchNickNameIvCheck.setOnClickListener {
            PatchNicknameService(this).tryPatchNickname(userIdx,jwt,binding.activityPatchNickNameEtNickname.text.toString() )

        }
    }

    override fun onPatchNicknameSuccess(response: PatchNicknamResponse) {
        showCustomToast("변경 성공")
        finish()
    }

    override fun onPatchNicknameFailuer(message: String) {

    }
}