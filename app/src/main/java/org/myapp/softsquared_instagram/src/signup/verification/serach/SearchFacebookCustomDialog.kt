package org.myapp.softsquared_instagram.src.signup.verification.serach

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import org.myapp.softsquared_instagram.databinding.DialogSearchPassBinding
import org.myapp.softsquared_instagram.src.signup.verification.profile.ProfileActivity

class SearchFacebookCustomDialog(nickName: String?, password: String?) : DialogFragment() {

    private lateinit var binding:DialogSearchPassBinding

    private val nickName = nickName
    private val password = password

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogSearchPassBinding.inflate(inflater,container,false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dialogSearchPassTvPass.setOnClickListener {
            dismiss()
            var intentSearch = Intent(view!!.context, ProfileActivity::class.java)
            intentSearch.putExtra("nickName",nickName)
            intentSearch.putExtra("password", password)
            startActivity(intentSearch)
        }
    }
}