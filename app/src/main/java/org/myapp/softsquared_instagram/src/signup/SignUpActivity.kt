package org.myapp.softsquared_instagram.src.signup

import android.content.Intent
import android.os.Bundle
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.config.PageAdapter
import org.myapp.softsquared_instagram.databinding.ActivitySignUpBinding
import org.myapp.softsquared_instagram.src.login.LoginActivity
import org.myapp.softsquared_instagram.src.signup.email.EmailFragment
import org.myapp.softsquared_instagram.src.signup.phone.PhoneFragment

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //로그인하기 클릭시
        binding.SignUpGoLogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        //뷰페이저 구현
        setpageAdapter()
    }

    fun setpageAdapter(){
        val adapter =  PageAdapter(supportFragmentManager)
        adapter.addFragment(PhoneFragment())
        adapter.addFragment(EmailFragment())
        binding.SignUpViewpager.adapter = adapter
        binding.SignUpTablayout.setupWithViewPager(binding.SignUpViewpager)

        binding.SignUpTablayout.getTabAt(0)?.setText("전화번호")
        binding.SignUpTablayout.getTabAt(1)?.setText("이메일")
    }
}