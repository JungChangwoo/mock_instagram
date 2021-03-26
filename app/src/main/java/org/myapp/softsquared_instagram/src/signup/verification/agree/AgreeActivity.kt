package org.myapp.softsquared_instagram.src.signup.verification.agree

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import okio.ByteString.Companion.toByteString
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityVerificationAgreeBinding
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.PostSignUpRequest
import org.myapp.softsquared_instagram.src.signup.verification.agree.models.SignUpResponse
import org.myapp.softsquared_instagram.src.signup.verification.welcome.WelcomeActivity
import kotlin.math.sign

class AgreeActivity :
    BaseActivity<ActivityVerificationAgreeBinding>(ActivityVerificationAgreeBinding::inflate), AgreeActivityView {

    private var preferencesEditor : SharedPreferences.Editor = ApplicationClass.sSharedPreferences.edit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //회원가입시 줘야할 변수들 선언
        var phoneNum = intent.getStringExtra("phonenum").toString()
        val name = intent.getStringExtra("name").toString()
        val password = intent.getStringExtra("password").toString()
        val year = intent.getStringExtra("year").toString()
        val month = intent.getStringExtra("month").toString()
        val day = intent.getStringExtra("day").toString()
        var email = intent.getStringExtra("email").toString()
        val nickName = "JungChangWoo"+(Math.random()*1000).toInt().toString()


        //어떤 방식으로 회원가입 했는지
        var isPhone : Boolean = email == "null"

        Log.d("ddddddddddddddddddd", name+password+phoneNum+email+year+month+day)

        //어떤 버튼의 상태가 변경되었는지 확인한다.
        binding.activityAgreeRbAll.setOnClickListener { onCheckChanged(binding.activityAgreeRbAll) }
        binding.activityAgreeRbService.setOnClickListener { onCheckChanged(binding.activityAgreeRbService) }
        binding.activityAgreeRbData.setOnClickListener { onCheckChanged(binding.activityAgreeRbData) }
        binding.activityAgreeRbLocation.setOnClickListener { onCheckChanged(binding.activityAgreeRbLocation) }

        //다음 버튼 누르면 회원가입
        binding.activityAgreeBtnNext.setOnClickListener {
            if(isPhone){
                // api에 POST로 보내면서 회원가입
                val signUpPostRequest = PostSignUpRequest(email = null , phoneNum = phoneNum, name = name,
                    password = password, birth = "2020-10-20", nickName = nickName)
                showLoadingDialog(this)
                AgreeService(this).tryPostSignUp(signUpPostRequest)
                Log.d("dddddddddd", "휴대폰으로 가입" )
                var intent_agree = Intent(this, WelcomeActivity::class.java)
                intent_agree.putExtra("nickName", nickName)
                intent_agree.putExtra("password", password)
                startActivity(intent_agree)

            } else {
                // api에 POST로 보내면서 회원가입
                val signUpPostRequest = PostSignUpRequest(email = email, phoneNum = null, name = name,
                    password = password, birth = "2020-10-20", nickName = nickName)
                showLoadingDialog(this)
                AgreeService(this).tryPostSignUp(signUpPostRequest)
                Log.d("dddddddddd", "이메일로 가입" )
                var intent_agree = Intent(this, WelcomeActivity::class.java)
                intent_agree.putExtra("nickName", nickName)
                intent_agree.putExtra("password", password)
                startActivity(intent_agree)
            }
        }

    }

    //상태 변화에 따라서 체크박스의 상태를 변경한다.
    private fun onCheckChanged(checkbox: CheckBox) {
        when (checkbox.id) {
            R.id.activity_agree_rb_all -> {
                if (binding.activityAgreeRbAll.isChecked) {
                    binding.activityAgreeRbService.isChecked = true
                    binding.activityAgreeRbData.isChecked = true
                    binding.activityAgreeRbLocation.isChecked = true
                    //버튼 활성화
                    binding.activityAgreeBtnNext.isEnabled = true
                    binding.activityAgreeBtnNext.isClickable = true
                    binding.activityAgreeBtnNext.setBackgroundResource(R.drawable.login_login_btn_background)
                } else {
                    binding.activityAgreeRbService.isChecked = false
                    binding.activityAgreeRbData.isChecked = false
                    binding.activityAgreeRbLocation.isChecked = false
                    //버튼 비활성화
                    binding.activityAgreeBtnNext.isEnabled = false
                    binding.activityAgreeBtnNext.isClickable = false
                    binding.activityAgreeBtnNext.setBackgroundResource(R.drawable.unactive_facebook_color_btn)
                }
            }
            else -> {
                binding.activityAgreeRbAll.isChecked = (
                    binding.activityAgreeRbService.isChecked
                    && binding.activityAgreeRbData.isChecked
                    && binding.activityAgreeRbLocation.isChecked
                 )
                if(binding.activityAgreeRbAll.isChecked){
                    //버튼 활성화
                    binding.activityAgreeBtnNext.isEnabled = true
                    binding.activityAgreeBtnNext.isClickable = true
                    binding.activityAgreeBtnNext.setBackgroundResource(R.drawable.login_login_btn_background)
                } else {
                    //버튼 비활성화
                    binding.activityAgreeBtnNext.isEnabled = false
                    binding.activityAgreeBtnNext.isClickable = false
                    binding.activityAgreeBtnNext.setBackgroundResource(R.drawable.unactive_facebook_color_btn)
                }
            }
        }

    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        dismissLoadingDialog()
        //showCustomToast(response.result.userIdx.toString())
        /*var intent_agree = Intent(this, WelcomeActivity::class.java)
        preferencesEditor.putString("nickName",nickName)
        startActivity(intent_agree)*/
        showCustomToast(response.message.toString())
    }

    override fun onPostSignUpFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}