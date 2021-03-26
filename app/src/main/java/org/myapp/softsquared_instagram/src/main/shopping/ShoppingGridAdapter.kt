package org.myapp.softsquared_instagram.src.main.shopping

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import org.myapp.softsquared_instagram.databinding.FragmentMypageGridviewItemBinding
import org.myapp.softsquared_instagram.databinding.ShoppingGridItemBinding

class ShoppingGridAdapter(private var context: Context, private var shoppingList : ArrayList<ShoppingData>)
    : BaseAdapter() {

    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: ShoppingGridItemBinding

    override fun getCount(): Int = shoppingList.size

    override fun getItem(position: Int): Any = shoppingList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        binding = ShoppingGridItemBinding.inflate(inflater, parent, false)
        binding.shoppingGridItemTvShopName.text = shoppingList[position].shopName
        binding.shoppingGridItemIvShopImage.setImageResource(shoppingList[position].shopImage)
        return binding.root
    }

}