package org.myapp.softsquared_instagram.src.main.home.comments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.src.main.home.comments.models.ResultCommentsList
import org.w3c.dom.Text

class CommentsRecyclerAdapter(val context: Context, private val commentsList : ArrayList<ResultCommentsList> ) : RecyclerView.Adapter<CommentsRecyclerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : CommentsRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.comments_item, parent, false)

        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return commentsList.count()
    }

    override fun onBindViewHolder(holder: CommentsRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(commentsList[position], context)
    }

    inner class ViewHolder(itemView : View?): RecyclerView.ViewHolder(itemView!!){
        private val profileImage = itemView?.findViewById<ImageView>(R.id.comments_item_iv_profile)
        private val nickName = itemView?.findViewById<TextView>(R.id.comments_item_tv_nickName)
        private val content = itemView?.findViewById<TextView>(R.id.comments_item_tv_content)

        fun bind(itemComments:ResultCommentsList?, context: Context){
            profileImage?.setImageResource(R.drawable.instagram_mypage)
            nickName?.text = itemComments?.nickName
            content?.text = itemComments?.commentContent
        }
    }


}