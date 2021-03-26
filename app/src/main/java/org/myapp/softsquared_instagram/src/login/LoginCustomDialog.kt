package org.myapp.softsquared_instagram.src.login

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.databinding.DialogLoginErrorBinding
import org.myapp.softsquared_instagram.src.signup.SignUpActivity

class LoginCustomDialog : DialogFragment() {

    private lateinit var binding : DialogLoginErrorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DialogLoginErrorBinding.inflate(inflater, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dialogLoginErrorTvAgain.setOnClickListener {
            dismiss()
        }
        binding.dialogLoginErrorTvSignup.setOnClickListener {
            startActivity(Intent(view!!.context,SignUpActivity::class.java))
        }
    }
}