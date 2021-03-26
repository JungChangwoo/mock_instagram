package org.myapp.softsquared_instagram.src.signup.verification.birthday

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityVerificationAgreeBinding
import org.myapp.softsquared_instagram.databinding.ActivityVerificationBirthdayBinding
import org.myapp.softsquared_instagram.src.login.LoginActivity
import org.myapp.softsquared_instagram.src.signup.verification.agree.AgreeActivity
import java.util.*

class BirthdayActivity : BaseActivity<ActivityVerificationBirthdayBinding>(ActivityVerificationBirthdayBinding::inflate){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //전화번호 이메일 이름 비밀번호 받아오기
        val phonenum = intent.getStringExtra("phonenum")
        val name = intent.getStringExtra("name")
        val password = intent.getStringExtra("password")
        val email = intent.getStringExtra("email")



        //현재 날짜 구하기 위해 init
        calendar = Calendar.getInstance()
        //현재 년도, 월, 일 구하기
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        //선택된 년도, 월, 일
        var Year =""
        var Month = 0
        var Day =""

        var check_age = 0;

        //hint에 현재 Date
        binding.activityBirthdayTvShowbirthday.hint = "$currentYear"+"년 "+"${currentMonth+1}"+"월 "+"$currentDay"+"일"

        //날짜 선택시
        binding.activityBirthdayDpDatepicker.init(currentYear, currentMonth, currentDay, DatePicker.OnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            binding.activityBirthdayTvShowbirthday.text = "$year"+"년 "+"${monthOfYear+1}"+"월 "+"${dayOfMonth}"+"일"
            Year = year.toString()
            Month = monthOfYear+1
            Day = dayOfMonth.toString()

            var age = calculateAge(currentYear,currentMonth,currentDay,year,monthOfYear,dayOfMonth)
            check_age = age
            if(age<=5) {
                binding.activityBirthdayTvShowage.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else{
                binding.activityBirthdayTvShowage.setTextColor(ContextCompat.getColor(this, R.color.lightgray))
            }
            binding.activityBirthdayTvShowage.text = age.toString()+"세"
            binding.activityBirthdayTvShowage.visibility = View.VISIBLE
        })

        //다음 버튼 누르면 activity넘어감 근데 만 14세 미만이면 오류 dialog생성
        binding.activityBirthdayBtnNext.setOnClickListener {
            if(check_age <14){
                //error dialog 띄우고 확인 버튼 누르면 login 화면으로 돌아옴
                val birthdayDialog = BirthdayCustomDialog()
                birthdayDialog.show(supportFragmentManager, "age error")
            } else{
                var intent_birthday = Intent(this, AgreeActivity::class.java)
                intent_birthday.putExtra("phonenum", phonenum)
                intent_birthday.putExtra("email", email)
                intent_birthday.putExtra("name", name)
                intent_birthday.putExtra("password", password)
                //생일 변수
                intent_birthday.putExtra("year", Year)
                intent_birthday.putExtra("month", Month.toString())
                intent_birthday.putExtra("day", Day)
                Log.d("dddddddddddddddddddddd", phonenum+email+name+password+Year+Month.toString()+Day)
                startActivity(intent_birthday)
            }
        }

    }
    fun calculateAge(currentYear:Int,currentMonth:Int,currentDay:Int,year:Int, month:Int, dayofmonth:Int): Int {
        var age = currentYear - year
        if(month*100 + dayofmonth > currentMonth*100+currentDay) age--
        return age
    }

}