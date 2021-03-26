package org.myapp.softsquared_instagram.src.main

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityMainBinding
import org.myapp.softsquared_instagram.src.main.home.HomeFragment
import org.myapp.softsquared_instagram.src.main.mypage.MypageFragment
import org.myapp.softsquared_instagram.src.main.search.SearchFragment
import org.myapp.softsquared_instagram.src.main.UploadFragment.UploadFragement
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

        val postImageUrl = intent.getStringExtra("postImageUrl").toString()
        val content = intent.getStringExtra("content").toString()

        Log.d("ffffffffffffffffffffffffffff",  postImageUrl+content)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment().apply {
            arguments = Bundle().apply {
                putString("postImageUrl", postImageUrl)
                putString("content", content)
            }
        }).commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
         BottomNavigationView.OnNavigationItemSelectedListener { item ->
             when (item.itemId) {
                 R.id.menu_main_btm_nav_home -> {
                     supportFragmentManager.beginTransaction()
                         .replace(R.id.main_frm, HomeFragment())
                         .commitAllowingStateLoss()
                     return@OnNavigationItemSelectedListener true
                 }
                 R.id.menu_main_btm_nav_search -> {
                     supportFragmentManager.beginTransaction()
                         .replace(R.id.main_frm, SearchFragment())
                         .commitAllowingStateLoss()
                     return@OnNavigationItemSelectedListener true
                 }
                 R.id.menu_main_btm_nav_reels -> {
                     supportFragmentManager.beginTransaction()
                         .replace(R.id.main_frm, UploadFragement())
                         .commitAllowingStateLoss()
                     return@OnNavigationItemSelectedListener true
                 }
                 R.id.menu_main_btm_nav_shopping -> {
                     supportFragmentManager.beginTransaction()
                         .replace(R.id.main_frm, ShoppingFragment())
                         .commitAllowingStateLoss()
                     return@OnNavigationItemSelectedListener true
                 }
                 R.id.menu_main_btm_nav_mypage -> {
                     supportFragmentManager.beginTransaction()
                         .replace(R.id.main_frm, MypageFragment().apply {
                             arguments = Bundle().apply {
                                 putString("nickName",nickName)
                                 putBoolean("isme",true)
                                 putString("jwt",jwt)
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

    fun setMypageFragment(nickName : String){
        supportFragmentManager.beginTransaction().replace(R.id.main_frm,MypageFragment().apply {
            arguments = Bundle().apply {
                putString("nickName",nickName)
                putBoolean("isme", false)
                putString("jwt", jwt)
                putString("userIdx",userIdx)
            }
        }).commitAllowingStateLoss()
    }

}