package org.myapp.softsquared_instagram.src.signup.email

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseFragment
import org.myapp.softsquared_instagram.databinding.FragmentSignUpEmailBinding
import org.myapp.softsquared_instagram.src.signup.email.models.UserEmailResponse
import org.myapp.softsquared_instagram.src.signup.verification.namepassword.NamePasswordActivity

class EmailFragment : BaseFragment<FragmentSignUpEmailBinding>(FragmentSignUpEmailBinding::bind, R.layout.fragment_sign_up_email), EmailFragmentView{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.fragmentEmailIbDelete.setColorFilter(Color.parseColor("#A6A6A6"))
        //editext에 있는 delete 버튼 클릭시
        binding.fragmentEmailIbDelete.setOnClickListener {
            binding.fragmentEmailEmailinputEt.setText("")
        }

        //이메일 입력해야 버튼 활성화
        binding.fragmentEmailEmailinputEt.addTextChangedListener ( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.fragmentEmailEmailinputEt.length()==0){
                    binding.fragmentEmailBtnNext.isClickable = false
                    binding.fragmentEmailBtnNext.isEnabled = false
                    binding.fragmentEmailIbDelete.visibility = View.GONE
                    binding.fragmentEmailBtnNext.setBackgroundResource(R.drawable.unactive_facebook_color_btn)
                } else{
                    binding.fragmentEmailBtnNext.isClickable = true
                    binding.fragmentEmailBtnNext.isEnabled = true
                    binding.fragmentEmailIbDelete.visibility = View.VISIBLE
                    binding.fragmentEmailBtnNext.setBackgroundResource(R.drawable.login_login_btn_background)
                }
            }
        })
        //다음 버튼 눌렀을 때 이메일 형식 맞는지 확인
        binding.fragmentEmailBtnNext.setOnClickListener {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(binding.fragmentEmailEmailinputEt.text.toString()).matches()){
                binding.fragmentEmailEmailLinear.setBackgroundResource(R.drawable.edittext_red_background)
                binding.fragmentEmailTvError.setText("이메일 형식으로 입력해주세요.")
                binding.fragmentEmailTvError.visibility = View.VISIBLE
                //이메일 edittext 변경하면
                binding.fragmentEmailEmailinputEt.addTextChangedListener ( object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {
                    }
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        binding.fragmentEmailEmailLinear.setBackgroundResource(R.drawable.login_edittext_background)
                        binding.fragmentEmailTvError.visibility = View.GONE
                    }
                })
            } else{
                //api에 중복된 이메일이 있는지확인
                showLoadingDialog(context!!)
                EmailService(this).tryGetEmailUsers(binding.fragmentEmailEmailinputEt.text.toString())
            }
        }
    }

    override fun onGetEmailUserSuccess(response: UserEmailResponse) {
        dismissLoadingDialog()
        if(response.code == 1001){
            var email = binding.fragmentEmailEmailinputEt.text.toString()
            var email_intent = Intent(view!!.context, NamePasswordActivity::class.java)
            email_intent.putExtra("email",email)
            Log.d("ddddddddddd", email)
            startActivity(email_intent)
        } else if(response.code == 2021){
            val emailDialog = EmailCustomDialog()
            emailDialog.show(fragmentManager!!,"email error")
        }

    }

    override fun onGetEmailUserFailure(message: String) {

    }
}