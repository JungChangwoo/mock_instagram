package org.myapp.softsquared_instagram.src.main.mypage

import org.myapp.softsquared_instagram.src.main.mypage.models.FollowingResponse
import org.myapp.softsquared_instagram.src.main.mypage.models.MypageResponse
import org.myapp.softsquared_instagram.src.main.search.models.UserSearchResponse

interface MypageFragmentView {
    fun onGetMypageUserSuccess(response: MypageResponse)

    fun onGetMypageUserFailure(message:String)

    fun onGetFollowingSuccess(response : FollowingResponse)

    fun onGetFollowingFailure(message: String)
}