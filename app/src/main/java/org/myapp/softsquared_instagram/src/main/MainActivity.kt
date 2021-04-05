package org.myapp.softsquared_instagram.src.main

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityMainBinding
import org.myapp.softsquared_instagram.src.main.home.HomeFragment
import org.myapp.softsquared_instagram.src.main.mypage.MypageFragment
import org.myapp.softsquared_instagram.src.main.reels.ReelsFragment
import org.myapp.softsquared_instagram.src.main.search.SearchFragment
import org.myapp.softsquared_instagram.src.main.shopping.ShoppingFragment


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate){

    var jwt : String = ""
    var userIdx : String = ""
    var nickName : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nickName = intent.getStringExtra("nickName").toString()
        jwt = intent.getStringExtra("jwt").toString()
        userIdx = intent.getStringExtra("userIdx").toString()

        //val postImages = intent.getSerializableExtra("postImages") as ArrayList<PostImages>
        //val content = intent.getStringExtra("content").toString()

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment().apply {
            arguments = Bundle().apply {
                //putSerializable("postImages", postImages)
                //putString("content", content)
            }
        }).commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        binding.mainBtmNav.setBackgroundResource(R.color.white)
                        binding.mainBtmNav.itemIconTintList = ContextCompat.getColorStateList(this,R.color.black)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_search -> {
                        binding.mainBtmNav.setBackgroundResource(R.color.white)
                        binding.mainBtmNav.itemIconTintList = ContextCompat.getColorStateList(this,R.color.black)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, SearchFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_reels -> {
                        binding.mainBtmNav.setBackgroundResource(R.color.black)
                        binding.mainBtmNav.itemIconTintList = ContextCompat.getColorStateList(this,R.color.white)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, ReelsFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_shopping -> {
                        binding.mainBtmNav.setBackgroundResource(R.color.white)
                        binding.mainBtmNav.itemIconTintList = ContextCompat.getColorStateList(this,R.color.black)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, ShoppingFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_mypage -> {
                        binding.mainBtmNav.setBackgroundResource(R.color.white)
                        binding.mainBtmNav.itemIconTintList = ContextCompat.getColorStateList(this,R.color.black)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MypageFragment().apply {
                                arguments = Bundle().apply {
                                    putString("nickName", nickName)
                                    putBoolean("isme", true)
                                    putString("jwt", jwt)
                                    putString("userIdx", userIdx)
                                }
                            })
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }
        )
    }

    fun setMypageFragment(nickName: String){
        supportFragmentManager.beginTransaction().replace(R.id.main_frm, MypageFragment().apply {
            arguments = Bundle().apply {
                putString("nickName", nickName)
                putBoolean("isme", false)
                putString("jwt", jwt)
                putString("userIdx", userIdx)
            }
        }).commitAllowingStateLoss()
    }
    fun updateStatusBarColor(color : String){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor(color)
        }
    }


}