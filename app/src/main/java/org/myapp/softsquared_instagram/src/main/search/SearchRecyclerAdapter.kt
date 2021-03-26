package org.myapp.softsquared_instagram.src.main.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.src.main.search.models.ResultSearch
import org.myapp.softsquared_instagram.src.main.search.models.SearchHistory

class SearchRecyclerAdapter(val context: Context, private val searchList: ArrayList<ResultSearch>, var onSearchViewClicked:SearchInterface) :
    RecyclerView.Adapter<SearchRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_search_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(searchList[position], context)
    }

    override fun getItemCount(): Int {
        return searchList.count()
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){

        private val profileImage = itemView?.findViewById<ImageView>(R.id.search_item_iv_profile)
        private val nickName = itemView?.findViewById<TextView>(R.id.search_item_tv_nickName)
        private val name = itemView?.findViewById<TextView>(R.id.search_item_tv_name)

        fun bind(itemSearch : ResultSearch?, context: Context){
            val profileImageUrl = itemSearch?.profileImageUrl.toString()

            if(profileImageUrl.isNotEmpty()){
                profileImage?.let { Glide.with(itemView).load(profileImageUrl).into(it) }
            } else{
                profileImage?.let { Glide.with(itemView).load("https://www.interview365.com/news/photo/201907/87957_114580_5511.jpg").into(it)}
            }
            nickName?.text = itemSearch?.nickName
            name?.text = itemSearch?.name

            var view : View = itemView
            view.rootView.setOnClickListener {
                val searchHistoryList = arrayListOf<SearchHistory>()
                onSearchViewClicked.onSearchViewClicked(nickName?.text.toString(), profileImageUrl, itemSearch?.name.toString())

            }
        }
    }
}