package org.myapp.softsquared_instagram.src.main.reels

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.myapp.softsquared_instagram.R

class ReelsFragmentAdapter(private val context : Context, private val reelsImage : ArrayList<Int>) : RecyclerView.Adapter<ReelsFragmentAdapter.ViewHolder>(){
    inner class ViewHolder(reelsItemView: View) : RecyclerView.ViewHolder(reelsItemView){

        private val reelsImage = reelsItemView.findViewById<ImageView>(R.id.reels_itme_iv_image)
        private val reelsmarquee = reelsItemView.findViewById<TextView>(R.id.reels_itme_tv_marquee)
        fun bind(itemReelsImage: Int, position: Int) {
            val itemReelsImage = itemReelsImage
            reelsImage?.let { Glide.with(context).load(itemReelsImage).into(it) }

            reelsmarquee.isSelected = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.reels_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reelsImage[position],position)
    }

    override fun getItemCount(): Int {
        return reelsImage.size
    }
}