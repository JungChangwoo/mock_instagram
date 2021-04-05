package org.myapp.softsquared_instagram.src.main.reels

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseFragment
import org.myapp.softsquared_instagram.databinding.FragmentMainReelsBinding


class ReelsFragment : BaseFragment<FragmentMainReelsBinding>(
    FragmentMainReelsBinding::bind,
    R.layout.fragment_main_reels
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val reelsArray = arrayListOf<Int>()
        reelsArray.add(R.drawable.reels)
        reelsArray.add(R.drawable.reels2)
        reelsArray.add(R.drawable.reels_imaga9)
        reelsArray.add(R.drawable.reels_image10)
        reelsArray.add(R.drawable.reels_image11)

        binding.fragmentReelsViewpager2.adapter = ReelsFragmentAdapter(context!!, reelsArray)
        binding.fragmentReelsViewpager2.orientation = ViewPager2.ORIENTATION_VERTICAL

        activity?.window?.statusBarColor = ContextCompat.getColor(context!!, R.color.black)
        activity?.window?.navigationBarColor = ContextCompat.getColor(context!!, R.color.black)


    }
}