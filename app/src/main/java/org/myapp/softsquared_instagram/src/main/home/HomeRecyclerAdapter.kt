package org.myapp.softsquared_instagram.src.main.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.home.models.ResultPost
import org.myapp.softsquared_instagram.src.main.home.models.ResultPostImages
import org.myapp.softsquared_instagram.src.main.home.models.ResultPostInfo

class HomeRecyclerAdapter(val context: Context, private val homeFeedList: ArrayList<ResultPost>)
    :RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_home_feed_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(homeFeedList[position].postInfo ,homeFeedList[position].postImages[0], context)
        Log.d("ssssssss", homeFeedList[position].postImages[0].toString())
    }

    override fun getItemCount(): Int {
        return homeFeedList.count()
    }

    inner class ViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView!!){
        private val nickName = itemView?.findViewById<TextView>(R.id.home_feed_item_tv_nickName)
        private val profileImage = itemView?.findViewById<ImageView>(R.id.home_feed_item_iv_profile)
        private val likeNum = itemView?.findViewById<TextView>(R.id.home_feed_item_tv_likeNum)
        private val myNickName = itemView?.findViewById<TextView>(R.id.home_feed_item_tv_content_nickName)
        private val content = itemView?.findViewById<TextView>(R.id.home_feed_item_tv_content_content)
        private val commentNum = itemView?.findViewById<TextView>(R.id.home_feed_item_tv_commentNum)
        private val feedImage = itemView?.findViewById<ImageView>(R.id.home_feed_item_iv_feed)
        private val option = itemView?.findViewById<ImageView>(R.id.home_feed_item_iv_option)

        fun bind(itemHomeFeed: ResultPostInfo?, itemFeedImage: ResultPostImages, context: Context){
            val profileImageUrl = itemHomeFeed?.profileImageUrl.toString()
            Log.d("ddddddddddddddddddddddd", profileImageUrl)

            /*if(profileImageUrl !== ""){
                profileImage?.let { Glide.with(itemView).load(profileImageUrl).into(it) }
            } else{
                profileImage?.setImageResource(R.drawable.instagram_mypage)
            }*/

            profileImage?.setImageResource(R.drawable.instagram_mypage)


            val feedImageUrl = itemFeedImage?.postUrl.toString()
            if(feedImageUrl.isNotEmpty()){
                feedImage?.let { Glide.with(itemView).load(feedImageUrl).into(it) }
            } else{
                feedImage?.visibility = View.VISIBLE
            }

            nickName?.text = itemHomeFeed?.nickName
            myNickName?.text = itemHomeFeed?.nickName
            likeNum?.text = itemHomeFeed?.numOfLike.toString()
            content?.text = itemHomeFeed?.content.toString()
            commentNum?.text = itemHomeFeed?.numOfComment.toString()

            option?.setOnClickListener {
                val deleteDialog = HomeDeleteDialog()
                //val fm : FragmentManager = context.
                //deleteDialog.show
            }

        }

    }


}