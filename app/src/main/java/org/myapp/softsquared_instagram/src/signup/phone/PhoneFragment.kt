package org.myapp.softsquared_instagram.src.signup.phone


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseFragment
import org.myapp.softsquared_instagram.databinding.FragmentSignUpPhoneBinding
import org.myapp.softsquared_instagram.src.signup.phone.models.UserPhoneResponse
import org.myapp.softsquared_instagram.src.signup.verification.namepassword.NamePasswordActivity
import java.util.regex.Pattern

class PhoneFragment : BaseFragment<FragmentSignUpPhoneBinding>(FragmentSignUpPhoneBinding::bind, R.layout.fragment_sign_up_phone),
    PhoneFragemntView  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.fragmentPhoneIbDelete.setColorFilter(Color.parseColor("#A6A6A6"))
        //editext에 있는 delete 버튼 클릭시
        binding.fragmentPhoneIbDelete.setOnClickListener {
            binding.fragmentPhonePhoneinputEt.setText("")
        }

        //전화번호 자동 하이픈
        binding.fragmentPhonePhoneinputEt.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        //전화번호 입력해야 버튼 활성화 AND
        binding.fragmentPhonePhoneinputEt.addTextChangedListener ( object :TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.fragmentPhonePhoneinputEt.length()==0){
                    binding.fragmentPhoneBtnNext.isClickable = false
                    binding.fragmentPhoneBtnNext.isEnabled = false
                    binding.fragmentPhoneIbDelete.visibility = View.GONE
                    binding.fragmentPhoneBtnNext.setBackgroundResource(R.drawable.unactive_facebook_color_btn)
                } else{
                    binding.fragmentPhoneBtnNext.isClickable = true
                    binding.fragmentPhoneBtnNext.isEnabled = true
                    binding.fragmentPhoneIbDelete.visibility = View.VISIBLE
                    binding.fragmentPhoneBtnNext.setBackgroundResource(R.drawable.login_login_btn_background)
                }
            }
        })

        //전화번호 다음 버튼 클릭시 전화번호 형식에 맞는지 확인
        binding.fragmentPhoneBtnNext.setOnClickListener {
            if (!Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}\$", binding.fragmentPhonePhoneinputEt.text.toString())){
                binding.fragmentPhoneLinearPhoneinput.setBackgroundResource(R.drawable.edittext_red_background)
                binding.fragmentPhoneTvError.text = "휴대폰 번호가 정확하지 않습니다. 국가 번호를 포함하여 전체 전화번호를 입력해주세요."
                binding.fragmentPhoneTvError.visibility = View.VISIBLE
                //다시 수정하기 시작하면 error표시 사라짐
                binding.fragmentPhonePhoneinputEt.addTextChangedListener ( object :TextWatcher {
                    override fun afterTextChanged(s: Editable?) {
                    }
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        binding.fragmentPhoneTvError.visibility = View.GONE
                        binding.fragmentPhoneLinearPhoneinput.setBackgroundResource(R.drawable.login_edittext_background)
                    }
                })
            } else {
                //api에 중복된 휴대폰 번호가 있는지확인
                    showLoadingDialog(context!!)
                    PhoneService(this).tryGetPhoneUsers(binding.fragmentPhonePhoneinputEt.text.toString())
            }
        }
    }

    override fun onGetPhoneUserSuccess(response: UserPhoneResponse){
        dismissLoadingDialog()
        if(response.code == 1002){
            var phonenum = binding.fragmentPhonePhoneinputEt.text.toString()
            var intent_phone = Intent(view!!.context, NamePasswordActivity::class.java)
            intent_phone.putExtra("phonenum", phonenum)
            Log.d("dddddddddddddd",phonenum)
            startActivity(intent_phone)
        } else{
            showCustomToast("오류 : "+response.message)
        }
    }

    override fun onGetPhoneUserFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }


}