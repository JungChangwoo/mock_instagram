package org.myapp.softsquared_instagram.src.main.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseFragment
import org.myapp.softsquared_instagram.databinding.FragmentMainHomeBinding
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.uploadpicture.UploadPictureActivity
import org.myapp.softsquared_instagram.src.main.home.models.*

class HomeFragment : BaseFragment<FragmentMainHomeBinding>(FragmentMainHomeBinding::bind, R.layout.fragment_main_home),HomeFragmentView{


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postImageUrl = arguments?.getString("postImageUrl").toString()
        val content = arguments?.getString("content").toString()
        Log.d("ffffffffffffffffffffffff",postImageUrl+content)

        val imageUrl = "https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg"
        val arrayList = arrayListOf<PostImages>()
        //arrayList.add(PostImages(imageUrl))
        Log.d("ddddddddd", arrayList.toString())
        binding.toolbarHome.toolbarHomeIvUpload.setOnClickListener {

            val intent = Intent(view!!.context, UploadPictureActivity::class.java)
            intent.putExtra("nickName", (activity as MainActivity).nickName)
            intent.putExtra("userIdx", (activity as MainActivity).userIdx)
            intent.putExtra("jwt", (activity as MainActivity).jwt)
            startActivity(intent)
        }
        showLoadingDialog(view!!.context)
        HomeService(this).tryGetHomeFeed((activity as MainActivity).userIdx,(activity as MainActivity).jwt)

        if(content !== "null"){
            arrayList.add(PostImages(postImageUrl))
            val postUploadRequest = PostUploadRequest(postImages = arrayList , content = content )
            //showLoadingDialog(view!!.context)
            HomeService(this).postUploadFeed((activity as MainActivity).userIdx, (activity as MainActivity).jwt, postUploadRequest)
        }
    }

    override fun onGetHomeFeedSuccess(response: HomeFeedResponse) {
        dismissLoadingDialog()
        showCustomToast("홈피드 GET 성공")
        setAdapter(response.result.post)
    }

    override fun onGetHomeFeedFailure(message: String) {

    }

    override fun onPostUploadSuccess(response: UploadResponse) {
        dismissLoadingDialog()
        showCustomToast("업로드 성공"+response.result.postIdx+response.code)

        HomeService(this).tryGetHomeFeed((activity as MainActivity).userIdx,(activity as MainActivity).jwt)
    }

    override fun onPostUploadFailure(message: String) {
        TODO("Not yet implemented")
    }

    private fun setAdapter(HomeFeedList: ArrayList<ResultPost>){
        val homeFeedAdapter = HomeRecyclerAdapter(view!!.context, HomeFeedList)
        binding.fragmentMainRecyclerview.adapter = homeFeedAdapter
        binding.fragmentMainRecyclerview.layoutManager = LinearLayoutManager(view!!.context)

    }
}