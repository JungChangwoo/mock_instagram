package org.myapp.softsquared_instagram.src.main.home

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.src.main.home.comments.CommentsActivity
import org.myapp.softsquared_instagram.src.main.home.models.*
import org.w3c.dom.Text

class HomeRecyclerAdapter(val context: Context, private val homeFeedList: ArrayList<ResultPost>, fragmentManager : FragmentManager, private val meNickName : String, private var onLikeClicked:HomeInterface, private val userIdx:String, private val jwt : String)
    :RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>(){

    private var mFragmentManager : FragmentManager = fragmentManager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_home_feed_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(homeFeedList[position].postInfo ,homeFeedList[position].postImages, context, mFragmentManager)
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
        private val feedViewPager = itemView?.findViewById<ViewPager2>(R.id.home_feed_item_viewPager2)
        private val option = itemView?.findViewById<ImageView>(R.id.home_feed_item_iv_option)
        private val tabLayout = itemView?.findViewById<TabLayout>(R.id.home_feed_item_tablayout)
        private val like = itemView?.findViewById<ImageView>(R.id.home_feed_item_iv_like)
        private val tvLike = itemView?.findViewById<TextView>(R.id.home_feed_item_tv_like)
        private val tvLikeUnit = itemView?.findViewById<TextView>(R.id.home_feed_item_tv_likeUnit)
        private val tvComment = itemView?.findViewById<TextView>(R.id.home_feed_item_tv_comment)
        private val tvCommentSee = itemView?.findViewById<TextView>(R.id.home_feed_item_tv_comment_see)
        private val writeComment = itemView?.findViewById<ImageView>(R.id.home_feed_item_iv_comment)

        fun bind(itemHomeFeed: ResultPostInfo?, itemFeedImages: ArrayList<ResultPostImages>, context: Context, mFragmentManager: FragmentManager){

            //좋아요 누르면
            if(itemHomeFeed!!.isLiked == "Y"){
                like!!.setImageResource(R.drawable.instagram_like_red)
            } else {
                like!!.setImageResource(R.drawable.instagram_history)
            }
            like!!.setOnClickListener {
                if(itemHomeFeed!!.isLiked == "Y"){
                    onLikeClicked.onLikeClicked(itemHomeFeed!!.postIdx)
                    like!!.setImageResource(R.drawable.instagram_history)
                    tvLike?.visibility = View.GONE
                    tvLikeUnit?.visibility = View.GONE
                    likeNum?.visibility = View.GONE
                } else{
                    onLikeClicked.onLikeClicked(itemHomeFeed!!.postIdx)
                    like.setImageResource(R.drawable.instagram_like_red)
                    likeNum?.text = "1"
                    tvLike?.visibility = View.VISIBLE
                    tvLikeUnit?.visibility = View.VISIBLE
                    likeNum?.visibility = View.VISIBLE
                }
            }

            //좋아요가 하나도 없으면 gone
            if(itemHomeFeed!!.numOfLike == 0){
                tvLike?.visibility = View.GONE
                tvLikeUnit?.visibility = View.GONE
                likeNum?.visibility = View.GONE
            }
            //댓글이 하나도 없으면 gone
            if(itemHomeFeed!!.numOfComment == 0){
                tvComment?.visibility = View.GONE
                commentNum?.visibility = View.GONE
                tvCommentSee?.visibility = View.GONE
            }
            //댓글 누르면 댓글 액티비티 열림
            writeComment?.setOnClickListener {
                val intentComment = Intent(context, CommentsActivity::class.java)
                intentComment.putExtra("userIdx", userIdx )
                intentComment.putExtra("jwt", jwt)
                intentComment.putExtra("postIdx", itemHomeFeed!!.postIdx.toString())
                context.startActivity(intentComment)
            }

            //프로필 이미지 set
            profileImage?.setImageResource(R.drawable.instagram_mypage)

            //viewpager set
            feedViewPager?.adapter = ViewPagerAdapter(itemFeedImages)
            feedViewPager?.orientation = ViewPager2.ORIENTATION_HORIZONTAL

            //이미지가 하나면 dot없음
            if(itemFeedImages.size== 1){
                tabLayout!!.visibility = View.GONE
            }
            //viewpager dot Indicator
            TabLayoutMediator(tabLayout!!, feedViewPager!!) { tab, position ->
                feedViewPager?.currentItem = tab.position
            }.attach()


            val firstFeedImageUrl = itemFeedImages[0].postUrl.toString()

            nickName?.text = itemHomeFeed?.nickName
            myNickName?.text = itemHomeFeed?.nickName
            likeNum?.text = itemHomeFeed?.numOfLike.toString()
            content?.text = itemHomeFeed?.content.toString()
            commentNum?.text = itemHomeFeed?.numOfComment.toString()
            //옵션 버튼 누르면
            option?.setOnClickListener {
                var isMe : Boolean
                Log.d("dddddddddddddddddd", meNickName+"  "+nickName?.text.toString())
                if(meNickName == nickName?.text.toString()){
                    isMe = true
                    val bottomDialogFragment = HomeBottomDialogFragment(isMe, itemHomeFeed!!.postIdx, itemHomeFeed.content, itemHomeFeed.nickName, firstFeedImageUrl)
                    bottomDialogFragment.show(mFragmentManager, bottomDialogFragment.tag)
                }else{
                    isMe = false
                    val bottomDialogFragment = HomeBottomDialogFragment(isMe, itemHomeFeed!!.postIdx, itemHomeFeed.content, itemHomeFeed.nickName, firstFeedImageUrl)
                    bottomDialogFragment.show(mFragmentManager, bottomDialogFragment.tag)
                }
            }

        }

    }
    inner class ViewPagerAdapter(private val postImageUrls : ArrayList<ResultPostImages>) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.view_pager2_postimages_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewPagerAdapter.ViewHolder, position: Int) {
            holder.bind(postImageUrls[position], position)
        }

        override fun getItemCount(): Int {
            return postImageUrls.size
        }
        inner class ViewHolder(postItemView : View) : RecyclerView.ViewHolder(postItemView){
            private val postImage = postItemView.findViewById<ImageView>(R.id.home_feed_item_iv_feed)

            fun bind(itemFeedImages:ResultPostImages, position:Int) {
                val postImageUrl = itemFeedImages.postUrl.toString()
                if(postImageUrl.isNotEmpty()){
                    postImage?.let { Glide.with(itemView).load(postImageUrl).into(it) }
                } else{
                    postImage?.visibility = View.VISIBLE
                }
            }

        }


    }



}