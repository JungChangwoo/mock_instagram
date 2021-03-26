package org.myapp.softsquared_instagram.src.main.mypage

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseFragment
import org.myapp.softsquared_instagram.databinding.FragmentMainMypageBinding
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.mypage.models.*
import org.myapp.softsquared_instagram.src.main.patchnickname.PatchNickname
import kotlin.collections.ArrayList

class MypageFragment:BaseFragment<FragmentMainMypageBinding>(FragmentMainMypageBinding::bind, R.layout.fragment_main_mypage),
    MypageFragmentView{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentMypageIvProfile.setImageResource(R.drawable.instagram_mypage)

        val nickName = arguments?.getString("nickName").toString()
        val isme = arguments?.getBoolean("isme")
        val jwt = arguments?.getString("jwt").toString()
        //val userIdx = arguments?.getString("userIdx").toString()
        Log.d("dddddddddddddd",jwt.toString())

        //자신의 마이페이지인지 다른 사람의 마이페이지인지
        if(isme == true){
            binding.fragmentMypageBtn1.text = "프로필 편집"
            binding.fragmentMypageBtn1.setTextColor(Color.parseColor("#000000"))
            binding.fragmentMypageBtn1.setBackgroundResource(R.drawable.button_white_background)
            binding.fragmentMypageBtn2.text = "저장됨"
            binding.fragmentMypageToolbar.toolbarMypageIvAlarm.setBackgroundResource(R.drawable.instagram_upload)
            binding.fragmentMypageToolbar.toolbarMypageIvBack.visibility = View.GONE
        } else{
            binding.fragmentMypageBtn1.text = "팔로우"
            binding.fragmentMypageBtn1.setTextColor(Color.parseColor("#FFFFFFFF"))
            binding.fragmentMypageBtn1.setBackgroundResource(R.drawable.login_login_btn_background)
            binding.fragmentMypageBtn2.text = "메세지"
            binding.fragmentMypageToolbar.toolbarMypageIvAlarm.setBackgroundResource(R.drawable.instagram_alarm)
            binding.fragmentMypageToolbar.toolbarMypageIvBack.visibility = View.VISIBLE
        }

        //프로필 편집 or 팔로우 버튼 누르기
        if(isme==true){
            binding.fragmentMypageBtn1.setOnClickListener {
                val patchNicknameIntent = Intent(view!!.context, PatchNickname::class.java)
                patchNicknameIntent.putExtra("nickName", nickName)
                patchNicknameIntent.putExtra("name", binding.fragmentMypageTvName.text.toString())
                patchNicknameIntent.putExtra("userIdx", (activity as MainActivity).userIdx)
                patchNicknameIntent.putExtra("jwt",(activity as MainActivity).jwt)
                startActivity(patchNicknameIntent)
            }
        } else{
            binding.fragmentMypageBtn1.setOnClickListener {
                val postFollowingRequest = PostFollowingRequest(followingNickName = nickName)
                showLoadingDialog(context!!)
                MypageService(this).tryPostFollowing((activity as MainActivity).userIdx,jwt ,postFollowingRequest)
            }
        }

        //마이페이지 API요청
        MypageService(this).tryGetMypageUsers(nickName,jwt,(activity as MainActivity).userIdx)
        Log.d("dddddddddddddddddddd",nickName+jwt)
        showLoadingDialog(context!!)

    }

    override fun onGetMypageUserSuccess(response: MypageResponse) {
        setMypageView(response.result.userInfo)
        setGridviewAdapter(response.result.post)
        dismissLoadingDialog()
    }

    override fun onGetMypageUserFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onGetFollowingSuccess(response: FollowingResponse) {
        dismissLoadingDialog()
        showCustomToast(response.message.toString())
        binding.fragmentMypageBtn1.setBackgroundResource(R.drawable.button_white_background)
        binding.fragmentMypageBtn1.text = "팔로잉"
        binding.fragmentMypageBtn1.setTextColor(Color.parseColor("#000000"))
    }

    override fun onGetFollowingFailure(message: String) {
        TODO("Not yet implemented")
    }

    private fun setMypageView(userInfo: ResultUserInfo) {
        binding.fragmentMypageToolbar.toolbarMypageTvNickName.text = userInfo.nickName
        binding.fragmentMypageTvName.text = userInfo.name
        binding.fragmentMypageTvUploadNum.text = userInfo.numOfPost.toString()
        binding.fragmentMypageTvFollowerNum.text = userInfo.follower.toString()
        binding.fragmentMypageTvFollowingNum.text = userInfo.following.toString()
        if(userInfo.isFollowed == "Y"){
            binding.fragmentMypageBtn1.setBackgroundResource(R.drawable.button_white_background)
            binding.fragmentMypageBtn1.text = "팔로잉"
            binding.fragmentMypageBtn1.setTextColor(Color.parseColor("#000000"))
        }
    }

    private fun setGridviewAdapter(uploadList : ArrayList<ResultPost>){
        val uploadAdapter = MypageGridviewAdapter(view!!.context, uploadList)
        binding.fragmentMypageGridview.adapter = uploadAdapter
    }
}