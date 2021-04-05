package org.myapp.softsquared_instagram.src.main.uploadpicture

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.bumptech.glide.Glide
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.databinding.ActivityUploadPictureBinding
import org.myapp.softsquared_instagram.databinding.ActivityUploadPictureItemBinding
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.home.models.PostImages
import org.myapp.softsquared_instagram.src.main.home.models.ResultPostImages
import org.myapp.softsquared_instagram.src.main.mypage.models.ResultPost
import org.myapp.softsquared_instagram.src.main.upload.UploadActivity

class UploadPictureGridviewAdapter(private var context: Context, private var pictureList: ArrayList<String>, private var nickName :String,private var userIdx : String, private  var jwt : String, private var choice : Boolean) : BaseAdapter()  {
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: ActivityUploadPictureItemBinding

    override fun getCount(): Int = pictureList.size

    override fun getItem(position: Int): Any = pictureList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        binding = ActivityUploadPictureItemBinding.inflate(inflater, parent, false)


        val pictureUrl = pictureList[position]
        if(pictureUrl.isNotEmpty()){
            binding.activityUploadPictureGridviewItem?.let { Glide.with(binding.root).load(pictureUrl).into(it) }
        }else{
            binding.activityUploadPictureGridviewItem?.visibility = View.VISIBLE }

        if (choice){
            binding.activityUploadPictureGridviewItemCheck.visibility = View.VISIBLE
        }

        return binding.root
    }

}