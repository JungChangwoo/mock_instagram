package org.myapp.softsquared_instagram.src.main.search

import org.myapp.softsquared_instagram.src.main.search.models.SearchHistory

interface SearchInterface {
    fun onSearchViewClicked(nickName : String, profileImage : String, name: String)
}