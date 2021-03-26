package org.myapp.softsquared_instagram.src.signup.email

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import org.myapp.softsquared_instagram.databinding.DialogOverlappingEmailBinding
import org.myapp.softsquared_instagram.src.login.LoginActivity
import org.myapp.softsquared_instagram.src.signup.SignUpActivity

class EmailCustomDialog : DialogFragment() {

    private lateinit var binding : DialogOverlappingEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogOverlappingEmailBinding.inflate(inflater,container,false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dialogOverlappingEmailTvNewSign.setOnClickListener {
            dismiss()
            var intentEmailError = Intent(view!!.context, SignUpActivity::class.java)
            intentEmailError.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intentEmailError)
        }
    }


}