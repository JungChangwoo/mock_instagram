package org.myapp.softsquared_instagram.src.main.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseFragment
import org.myapp.softsquared_instagram.databinding.FragmentMainSearchBinding
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.search.models.ResultSearch
import org.myapp.softsquared_instagram.src.main.search.models.SearchHistory
import org.myapp.softsquared_instagram.src.main.search.models.UserSearchResponse

class SearchFragment : BaseFragment<FragmentMainSearchBinding>(FragmentMainSearchBinding::bind, R.layout.fragment_main_search),
    SearchFragmentView, SearchInterface{

    val searchHistoryArray = arrayListOf<SearchHistory>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.window?.statusBarColor = ContextCompat.getColor(context!!, R.color.white)
        activity?.window?.navigationBarColor= ContextCompat.getColor(context!!, R.color.white)

        //edittext delete버튼 클릭시 다 지움
        binding.fragmentSearchIvSearchDelete.setOnClickListener{
            binding.fragmentSearchEtSearch.setText("")
            binding.fragmentSearchRecyclerview.visibility = View.GONE
        }

        //검색 입력할 때 마다 api호출 및 delete버튼의 생성조건
        binding.fragmentSearchEtSearch.addTextChangedListener ( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.fragmentSearchEtSearch.length()==0){
                    binding.fragmentSearchIvSearchDelete.visibility = View.GONE
                } else{
                    binding.fragmentSearchIvSearchDelete.visibility = View.VISIBLE
                    binding.fragmentSearchRecyclerview.visibility = View.GONE
                    SearchService(this@SearchFragment).tryGetSearchUsers(binding.fragmentSearchEtSearch.text.toString())
                }
            }
        })


    }

    private fun setHistoryAdapter(searchHistoryList : ArrayList<SearchHistory>, profileImageUrl:String, nickName:String, name:String){
        searchHistoryList.add(SearchHistory(profileImageUrl,nickName,name))
        val searchHistoryAdapter = SearchHistoryRecyclerAdapter(view!!.context, searchHistoryList, this,profileImageUrl, nickName, name)
        binding.fragmentSearchRecyclerview.adapter = searchHistoryAdapter
        binding.fragmentSearchRecyclerview.layoutManager = LinearLayoutManager(view!!.context)
    }

    private fun setAdapter(searchList: ArrayList<ResultSearch>){
        val searchAdapter = SearchRecyclerAdapter(view!!.context, searchList, this)
        binding.fragmentSearchRecyclerview.adapter = searchAdapter
        binding.fragmentSearchRecyclerview.layoutManager = LinearLayoutManager(view!!.context)

    }


    override fun onGetSearchUserSuccess(response: UserSearchResponse) {
        if (response.result.isEmpty()){
            showCustomToast("검색결과없음")
        } else{
            binding.fragmentSearchRecyclerview.visibility = View.VISIBLE
            setAdapter(response.result)
        }
    }

    override fun onGetSearchUserFailure(message: String) {

    }

    override fun onSearchViewClicked(nickName : String, profileImageUrl: String, name: String) {
        (activity as MainActivity).setMypageFragment(nickName)
        setHistoryAdapter(searchHistoryArray,profileImageUrl,nickName,name)
    }
}