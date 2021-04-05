package org.myapp.softsquared_instagram.src.main.shopping

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseFragment
import org.myapp.softsquared_instagram.databinding.FragmentShoppingBinding


class ShoppingFragment : BaseFragment<FragmentShoppingBinding>(FragmentShoppingBinding::bind, R.layout.fragment_shopping) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.statusBarColor = ContextCompat.getColor(context!!, R.color.white)
        activity?.window?.navigationBarColor= ContextCompat.getColor(context!!, R.color.white)

        val shoppingGridArray = arrayListOf<ShoppingData>()
        shoppingGridArray.add(ShoppingData("oiehofo", R.drawable.shopping_image1))
        shoppingGridArray.add(ShoppingData("oiehofo", R.drawable.shopping_image2))
        shoppingGridArray.add(ShoppingData("oiehofo", R.drawable.shopping2))
        shoppingGridArray.add(ShoppingData("oiehofo", R.drawable.shopping3))
        shoppingGridArray.add(ShoppingData("oiehofo", R.drawable.shopping4))
        shoppingGridArray.add(ShoppingData("oiehofo", R.drawable.shopping5))
        shoppingGridArray.add(ShoppingData("oiehofo", R.drawable.shopping6))
        shoppingGridArray.add(ShoppingData("oiehofo", R.drawable.shopping7))
        shoppingGridArray.add(ShoppingData("oiehofo", R.drawable.shopping8))
        shoppingGridArray.add(ShoppingData("oiehofo", R.drawable.shopping_image1))

        val shoppingAdapter = ShoppingGridAdapter(view!!.context, shoppingGridArray)
        binding.fragmentShoppingGridview.adapter = shoppingAdapter
    }
}