package org.myapp.softsquared_instagram.src.main.search

import org.myapp.softsquared_instagram.src.main.search.models.UserSearchResponse

interface SearchFragmentView {
    fun onGetSearchUserSuccess(response: UserSearchResponse)

    fun onGetSearchUserFailure(message:String)
}