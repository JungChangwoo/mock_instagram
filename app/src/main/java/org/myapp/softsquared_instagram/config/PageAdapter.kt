package org.myapp.softsquared_instagram.config

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter


class PageAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){
    private val fragmentList : ArrayList<Fragment> = ArrayList()

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }
    fun addFragment(fragment:Fragment){
        fragmentList.add(fragment)

    }
}