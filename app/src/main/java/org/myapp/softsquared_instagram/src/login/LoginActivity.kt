package org.myapp.softsquared_instagram.src.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityLoginBinding
import org.myapp.softsquared_instagram.src.login.models.LoginResponse
import org.myapp.softsquared_instagram.src.login.models.PostLoginRequest
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.signup.SignUpActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate), LoginActivityView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nickName = intent.getStringExtra("nickName")

        val password = intent.getStringExtra("password")

        binding.LoginEdittextId.setText(nickName)
        binding.LoginEdittextPassword.setText(password)


        if(binding.LoginEdittextId.length() !==0 || binding.LoginEdittextPassword.length() !== 0){
            binding.LoginButtonLogin.setBackgroundResource(R.drawable.login_login_btn_background)
            binding.LoginButtonLogin.isClickable = true
            binding.LoginButtonLogin.isEnabled = true
        }
        //닉네임 비밀번호 입력해야 버튼 활성화
        binding.LoginEdittextId.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) =
                if(binding.LoginEdittextPassword.length() !== 0){
                    binding.LoginButtonLogin.setBackgroundResource(R.drawable.login_login_btn_background)
                    binding.LoginButtonLogin.isEnabled = true
                    binding.LoginButtonLogin.isClickable = true
                }else{
                    binding.LoginButtonLogin.setBackgroundResource(R.drawable.unactive_facebook_color_btn)
                    binding.LoginButtonLogin.isEnabled = false
                    binding.LoginButtonLogin.isClickable = false
                }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        binding.LoginEdittextPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.LoginEdittextId.length() !== 0){
                    binding.LoginButtonLogin.setBackgroundResource(R.drawable.login_login_btn_background)
                    binding.LoginButtonLogin.isEnabled = true
                    binding.LoginButtonLogin.isClickable = true
                }else{
                    binding.LoginButtonLogin.setBackgroundResource(R.drawable.unactive_facebook_color_btn)
                    binding.LoginButtonLogin.isEnabled = false
                    binding.LoginButtonLogin.isClickable = false
                }
            }
            override fun afterTextChanged(s: Editable?) {

            }
        })




        //가입하기 버튼 누르면 SignUpActivity
        binding.LoginButtonSignUp.setOnClickListener {
            var intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        //페이스북 로그인 버튼 누르면 MainActivity
        binding.LoginButtonFacebookLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        //로그인 버튼 누르면 로그인 api요청 보내고 MainActivity로 이동
        binding.LoginButtonLogin.setOnClickListener {
            //로그인 api 호출
            val nickName = binding.LoginEdittextId.text.toString()
            val password = binding.LoginEdittextPassword.text.toString()
            val loginPostRequest = PostLoginRequest(nickName = nickName, password = password)
            showLoadingDialog(this)
            LoginService(this).tryPostLogin(loginPostRequest,nickName)
        }

    }

    override fun onPostLoginSuccess(response: LoginResponse, nickName: String) {
        dismissLoadingDialog()
        if(response.code == 1000){
            var intentLogin = Intent(this, MainActivity::class.java)
            intentLogin.putExtra("nickName",nickName)
            intentLogin.putExtra("jwt",response.result.jwt)
            intentLogin.putExtra("userIdx", response.result.userIdx.toString())
            Log.d("ddddddddddddd", response.result.jwt)
            Log.d("ddddddddddddd", response.result.userIdx.toString())
            startActivity(intentLogin)
        } else {
            val loginDialog = LoginCustomDialog()
            loginDialog.show(supportFragmentManager, "dialog")
        }
    }

    override fun onPostLoginFailure(message: String) {

    }
}
