package org.myapp.softsquared_instagram.src.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.databinding.BottomSheetDialogHomeBinding
import org.myapp.softsquared_instagram.src.login.LoginActivity
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.home.delete.FeedDeleteDialog
import org.myapp.softsquared_instagram.src.main.home.patch.FeedPatchActivity

class HomeBottomDialogFragment(
    private val isMe: Boolean,
    private val postIdx: Int,
    private val content: String,
    private val nickName : String,
    private val feedImageUrl : String
) : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetDialogHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = BottomSheetDialogHomeBinding.inflate(inflater, container, false)
        binding.bottomSheetDialog.setBackgroundResource(R.drawable.bottom_sheet_dialog_background)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //내 게시물이냐 아니냐에 따라서 메뉴가 달라짐
        if (!isMe) {
            binding.bottomSheetDialogTvSave.visibility = View.GONE
            binding.bottomSheetDialogTvDelete.visibility = View.GONE
            binding.bottomSheetDialogTvPatch.visibility = View.GONE
            binding.bottomSheetDialogTvComment.visibility = View.GONE
            binding.bottomSheetDialogTvUnfollow.visibility = View.VISIBLE
            binding.bottomSheetDialogTvHide.visibility = View.VISIBLE
        }

        binding.bottomSheetDialogTvDelete.setOnClickListener {
            val deleteDialog = FeedDeleteDialog(postIdx)
            deleteDialog.show(fragmentManager!!, deleteDialog.tag)
            dismiss()
        }
        binding.bottomSheetDialogTvPatch.setOnClickListener {
            val intent = Intent(context, FeedPatchActivity::class.java)
            intent.putExtra("postIdx", postIdx.toString())
            intent.putExtra("content", content)
            intent.putExtra("nickName", nickName)
            intent.putExtra("feedImageUrl", feedImageUrl)
            intent.putExtra("userIdx", (activity as MainActivity).userIdx)
            intent.putExtra("jwt", (activity as MainActivity).jwt)
            startActivity(intent)
            dismiss()
        }
    }


    //navigation 하얗게
    override fun getTheme(): Int = R.style.Theme_NoWiredStrapInNavigationBar


}