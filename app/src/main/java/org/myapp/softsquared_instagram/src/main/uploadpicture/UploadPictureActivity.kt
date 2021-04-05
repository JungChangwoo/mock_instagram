package org.myapp.softsquared_instagram.src.main.uploadpicture

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityUploadPictureBinding
import org.myapp.softsquared_instagram.src.main.home.models.PostImages
import org.myapp.softsquared_instagram.src.main.mypage.MypageGridviewAdapter
import org.myapp.softsquared_instagram.src.main.upload.UploadActivity

class UploadPictureActivity:BaseActivity<ActivityUploadPictureBinding>(ActivityUploadPictureBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nickName = intent.getStringExtra("nickName").toString()
        val userIdx = intent.getStringExtra("userIdx").toString()
        val jwt = intent.getStringExtra("jwt").toString()


        val pictureArrayList = arrayListOf<String>()
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://image.chosun.com/sitedata/image/202011/25/2020112502869_0.png")
        pictureArrayList.add("https://image.chosun.com/sitedata/image/202005/22/2020052200813_0.png")
        pictureArrayList.add("https://i.pinimg.com/originals/a6/98/29/a69829ae42389664436fa6a23869b9d0.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20160621-Reissue-glovis-brazil-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://www.hotelrestaurant.co.kr/data/photos/20190416/art_15554800195894_783572.bmp")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://i0.wp.com/www.agoda.com/wp-content/uploads/2019/04/Paris-itinerary-3-day-trip-France-Louvre-Museum.jpg")
        pictureArrayList.add("https://image.chosun.com/sitedata/image/202007/20/2020072001823_0.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://www.lottehotelmagazine.com/resources/d434c17f-5ac2-4b98-8021-f3bdd5cc26f4_img_TRAVEL_busan_detail01.jpg")
        pictureArrayList.add("https://japan-magazine.jnto.go.jp/jnto2wm/wp-content/uploads/1608_special_TOTO_main.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")
        pictureArrayList.add("https://blog.hmgjournal.com/images/contents/article/20161013-Reissue-city-nightview-01.jpg")

        binding.activityUploadPictureIvChoice.setOnClickListener {
            binding.activityUploadPictureIvChoice.setImageResource(R.drawable.upload_multiple)
            val pictureAdapter =
                UploadPictureGridviewAdapter(this, pictureArrayList, nickName, userIdx, jwt, true)
            binding.activityUploadPictureGridview.adapter = pictureAdapter
        }

        val pictureAdapter =
            UploadPictureGridviewAdapter(this, pictureArrayList, nickName, userIdx, jwt, false)
        binding.activityUploadPictureGridview.adapter = pictureAdapter

        var postImages = arrayListOf<PostImages>()
        binding.activityUploadPictureGridview.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                postImages.add(PostImages(pictureArrayList[position]))
                Log.d("DDDDDDDDDDDDDDD", postImages.toString())
                showCustomToast("사진이 추가되었습니다.")
            }
        binding.activityUploadPictureNext.setOnClickListener {
            val intent = Intent(this, UploadActivity::class.java)
            //Log.d("dddddddddddddddddd", postImages.toString())
            intent.putExtra("postImages", postImages)
            //Log.d("dddddddddddddddddd", postImages.toString())
            intent.putExtra("nickName", nickName)
            intent.putExtra("userIdx", userIdx)
            intent.putExtra("jwt", jwt)
            startActivity(intent)
        }

    }

}

