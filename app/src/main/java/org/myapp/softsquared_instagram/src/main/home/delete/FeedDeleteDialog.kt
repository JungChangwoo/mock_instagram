package org.myapp.softsquared_instagram.src.main.home.delete

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import org.myapp.softsquared_instagram.databinding.DialogFeedDeleteBinding
import org.myapp.softsquared_instagram.src.main.MainActivity
import org.myapp.softsquared_instagram.src.main.home.HomeChangeInterface
import org.myapp.softsquared_instagram.src.main.home.delete.models.FeedDeleteResponse
import android.widget.Toast.makeText as makeText1

class FeedDeleteDialog(private val postIdx : Int) : DialogFragment(), FeedDeleteDialogView , HomeChangeInterface{

    private lateinit var binding : DialogFeedDeleteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DialogFeedDeleteBinding.inflate(inflater,container,false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dialogFeedDeleteTvDelete.setOnClickListener {
            FeedDeleteService(this).tryPatchFeedDelete((activity as MainActivity).userIdx, (activity as MainActivity).jwt, postIdx)
            dismiss()
        }
    }

    override fun onPatchFeedDeleteSuccess(response : FeedDeleteResponse) {
        Log.d("ddddddddddddddd", response.result.postIdx.toString())
        onHomeChangeInterface()
        //Toast.makeText(view!!.context, "삭제 성공", Toast.LENGTH_SHORT).show()
    }

    override fun onPatchFeedDeleteFailure(message : String) {

    }

    override fun onHomeChangeInterface() {
    }
}