package org.myapp.softsquared_instagram.src.main.search

import org.myapp.softsquared_instagram.config.ApplicationClass
import org.myapp.softsquared_instagram.src.main.search.models.UserSearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchService(val view: SearchFragmentView) {

    fun tryGetSearchUsers(nickName : String){
        val searchRetrofitInterface = ApplicationClass.sRetrofit.create(SearchRetrofitInterface::class.java)
        searchRetrofitInterface.getSearchUsers(nickName).enqueue(object : Callback<UserSearchResponse> {
            override fun onResponse(
                call: Call<UserSearchResponse>,
                response: Response<UserSearchResponse>
            ) {
                view.onGetSearchUserSuccess(response.body()as UserSearchResponse)
            }

            override fun onFailure(call: Call<UserSearchResponse>, t: Throwable) {
                view.onGetSearchUserFailure(t.message ?: "통신 오류")
            }

        })
    }
}