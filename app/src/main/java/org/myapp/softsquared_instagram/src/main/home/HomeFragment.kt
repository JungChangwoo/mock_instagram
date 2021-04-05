package org.myapp.softsquared_instagram.src.main.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseFragment
import org.myapp.softsquared_instagram.databinding.FragmentMainHomeBinding
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.uploadpicture.UploadPictureActivity
import org.myapp.softsquared_instagram.src.main.home.models.*
import org.myapp.softsquared_instagram.src.main.home.story.StoryActivity

class HomeFragment : BaseFragment<FragmentMainHomeBinding>(FragmentMainHomeBinding::bind, R.layout.fragment_main_home),HomeFragmentView, HomeInterface,HomeChangeInterface{


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.window?.statusBarColor = ContextCompat.getColor(context!!, R.color.white)
        activity?.window?.navigationBarColor= ContextCompat.getColor(context!!, R.color.white)


        /*val postImages = arguments?.getSerializable("postImages")
        val content = arguments?.getString("content").toString()*/

        binding.fragmentMainStory2.setOnClickListener {
            startActivity(Intent(context,StoryActivity::class.java))
        }

        binding.toolbarHome.toolbarHomeIvUpload.setOnClickListener {

            val intent = Intent(view!!.context, UploadPictureActivity::class.java)
            intent.putExtra("nickName", (activity as MainActivity).nickName)
            intent.putExtra("userIdx", (activity as MainActivity).userIdx)
            intent.putExtra("jwt", (activity as MainActivity).jwt)
            startActivity(intent)
        }
        showLoadingDialog(view!!.context)
        HomeService(this).tryGetHomeFeed((activity as MainActivity).userIdx,(activity as MainActivity).jwt)

        /*if(content !== "null"){
            val postUploadRequest = PostUploadRequest(postImages = postImages , content = content )
            //showLoadingDialog(view!!.context)
            HomeService(this).postUploadFeed((activity as MainActivity).userIdx, (activity as MainActivity).jwt, postUploadRequest)
        }*/

    }

    override fun onGetHomeFeedSuccess(response: HomeFeedResponse) {
        dismissLoadingDialog()
        showCustomToast("홈피드 GET 성공")
        setAdapter(response.result.post)
    }

    override fun onGetHomeFeedFailure(message: String) {

    }

    override fun onPostLikeSuccess(response: PostLikeResponse) {
        showCustomToast(response.result.likeStatus)
    }

    override fun onPostLikeFailure(message: String) {
        TODO("Not yet implemented")
    }


    private fun setAdapter(HomeFeedList: ArrayList<ResultPost>){
        val homeFeedAdapter = HomeRecyclerAdapter(view!!.context, HomeFeedList, fragmentManager!!, (activity as MainActivity).nickName, this, (activity as MainActivity).userIdx,(activity as MainActivity).jwt)
        binding.fragmentMainRecyclerview.adapter = homeFeedAdapter
        binding.fragmentMainRecyclerview.layoutManager = LinearLayoutManager(view!!.context)

    }

    override fun onLikeClicked(postIdx: Int) {
        HomeService(this).tryPostLike((activity as MainActivity).userIdx, (activity as MainActivity).jwt, postIdx)
    }

    override fun onHomeChangeInterface() {
        showLoadingDialog(context!!)
        HomeService(this).tryGetHomeFeed((activity as MainActivity).userIdx,(activity as MainActivity).jwt)
    }
}