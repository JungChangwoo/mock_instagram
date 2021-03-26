package org.myapp.softsquared_instagram.src.signup.verification.namepassword

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityPhoneVerificationNamePasswordBinding
import org.myapp.softsquared_instagram.src.signup.verification.birthday.BirthdayActivity

class NamePasswordActivity : BaseActivity<ActivityPhoneVerificationNamePasswordBinding>(ActivityPhoneVerificationNamePasswordBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //휴대폰 번호 받아오기
        val phonenum = intent.getStringExtra("phonenum")
        //이메일 받아오기
        val email = intent.getStringExtra("email")

        //성명 edittext에 있는 delete 클릭시
        binding.activityVerifiIbDelete.setOnClickListener {
            binding.activityVerifiEtName.setText("")
        }

        //성명 delete 버튼 생성
        binding.activityVerifiEtName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //성명 et delete버튼 생성
                if(binding.activityVerifiEtName.length()==0){
                    binding.activityVerifiIbDelete.visibility = View.GONE
                } else {
                   binding.activityVerifiIbDelete.visibility = View.VISIBLE
                }
            }
        })
        binding.activityVerifiEtPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //밀번호 6글자 이상일 때 버튼 활성화
                if(binding.activityVerifiEtPassword.length() >= 6){
                    binding.activityVerifiConnect.setBackgroundResource(R.drawable.login_login_btn_background)
                    binding.activityVerifiNotconnect.setTextColor(resources.getColor(R.color.facebook_color))
                    binding.activityVerifiConnect.isEnabled = true
                    binding.activityVerifiConnect.isClickable = true
                    binding.activityVerifiNotconnect.isEnabled = true
                    binding.activityVerifiNotconnect.isClickable = true

                } else {
                    binding.activityVerifiConnect.setBackgroundResource(R.drawable.unactive_facebook_color_btn)
                    binding.activityVerifiNotconnect.setTextColor(resources.getColor(R.color.unactive_facebook_color))
                    binding.activityVerifiConnect.isEnabled = false
                    binding.activityVerifiConnect.isClickable = false
                    binding.activityVerifiNotconnect.isEnabled = false
                    binding.activityVerifiNotconnect.isClickable = false
                }
            }
        })

        //비밀번호 포커스 잃었을 때 6자 이상이 아닌 경우 에러 발생
        binding.activityVerifiEtPassword.setOnFocusChangeListener(object : View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if(hasFocus){

                } else {
                    if(binding.activityVerifiEtPassword.length() < 6){
                        binding.activityVerifiEtPassword.setBackgroundResource(R.drawable.edittext_red_background)
                        binding.activityVerifiTvError.visibility = View.VISIBLE
                    } else {
                        binding.activityVerifiEtPassword.setBackgroundResource(R.drawable.login_edittext_background)
                        binding.activityVerifiTvError.visibility = View.GONE
                    }

                }
            }
        })

        //계속 진행하여 연락처 동기화하기 클릭
        binding.activityVerifiConnect.setOnClickListener {
            var intent_name_password = Intent(this, BirthdayActivity::class.java)
            intent_name_password.putExtra("phonenum",phonenum)
            intent_name_password.putExtra("email", email)
            intent_name_password.putExtra("name",binding.activityVerifiEtName.text.toString())
            intent_name_password.putExtra("password", binding.activityVerifiEtPassword.text.toString())
            startActivity(intent_name_password)
        }
        //연락처를 동기화하지 않고 계속하기 클릭
        binding.activityVerifiNotconnect.setOnClickListener {
            var intent_name_password = Intent(this, BirthdayActivity::class.java)
            intent_name_password.putExtra("phonenum",phonenum)
            intent_name_password.putExtra("email", email)
            intent_name_password.putExtra("name",binding.activityVerifiEtName.text.toString())
            intent_name_password.putExtra("password", binding.activityVerifiEtPassword.text.toString())
            startActivity(intent_name_password)
        }

    }
}