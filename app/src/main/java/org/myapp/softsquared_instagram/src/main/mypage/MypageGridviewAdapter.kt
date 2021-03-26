package org.myapp.softsquared_instagram.src.main.mypage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import org.myapp.softsquared_instagram.databinding.FragmentMypageGridviewItemBinding
import org.myapp.softsquared_instagram.src.main.mypage.models.ResultPost

class MypageGridviewAdapter(private var context: Context, private var uploadList: ArrayList<ResultPost>
) : BaseAdapter() {

    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: FragmentMypageGridviewItemBinding

    override fun getCount(): Int = uploadList.size

    override fun getItem(position: Int): Any = uploadList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        binding = FragmentMypageGridviewItemBinding.inflate(inflater, parent, false)

        val upLoadUrl = uploadList[position].imageUrl.toString()

        if(upLoadUrl.isNotEmpty()){
            binding.mypageGridviewItem?.let { Glide.with(binding.root).load(upLoadUrl).into(it) }
        }else{
            binding.mypageGridviewItem?.visibility = View.VISIBLE }
        return binding.root
    }

}