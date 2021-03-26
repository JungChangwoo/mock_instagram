package org.myapp.softsquared_instagram.src.main.search

import org.myapp.softsquared_instagram.src.main.search.models.UserSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRetrofitInterface {
    @GET("/users/info?")
    fun getSearchUsers(
        @Query("nickName") nickName : String
    ) : Call<UserSearchResponse>
}