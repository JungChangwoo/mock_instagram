package org.myapp.softsquared_instagram.src.signup.verification.birthday

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import org.myapp.softsquared_instagram.databinding.DialogAgeErrorBinding
import org.myapp.softsquared_instagram.databinding.DialogLoginErrorBinding
import org.myapp.softsquared_instagram.src.login.LoginActivity
import org.myapp.softsquared_instagram.src.signup.SignUpActivity

class BirthdayCustomDialog : DialogFragment() {

    private lateinit var binding : DialogAgeErrorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DialogAgeErrorBinding.inflate(inflater, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dialogAgeErrorTvOk.setOnClickListener {
            dismiss()
            var intentAgeError =Intent(view!!.context, LoginActivity::class.java)
            intentAgeError.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intentAgeError)
        }
    }
}