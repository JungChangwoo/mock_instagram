package org.myapp.softsquared_instagram.src.main.upload

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.main.home.HomeRetrofitInterface
import org.myapp.softsquared_instagram.src.main.upload.models.PostUploadRequest
import org.myapp.softsquared_instagram.src.main.upload.models.UploadResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UploadService(val view : UploadActivityView) {

    fun postUploadFeed(userIdx:String, jwt : String, uploadRequest : PostUploadRequest) {
        val uploadRetrofitInterface = ApplicationClass.sRetrofit.create(UploadRetrofitInterface::class.java)
        uploadRetrofitInterface.uploadFeed(userIdx,jwt,uploadRequest).enqueue(object :
            Callback<UploadResponse> {
            override fun onResponse(call: Call<UploadResponse>, response: Response<UploadResponse>
            ) {
                view.onPostUploadSuccess(response.body() as UploadResponse)
            }

            override fun onFailure(call: Call<UploadResponse>, t: Throwable) {
                view.onPostUploadFailure(t.message ?: "통신 오류")
            }

        })
    }
}