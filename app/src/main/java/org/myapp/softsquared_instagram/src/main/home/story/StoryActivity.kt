package org.myapp.softsquared_instagram.src.main.home.story

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.style.UpdateAppearance
import android.view.WindowManager
import androidx.core.content.ContextCompat
import org.myapp.softsquared_instagram.R
import org.myapp.softsquared_instagram.config.BaseActivity
import org.myapp.softsquared_instagram.databinding.ActivityStoryBinding
import org.myapp.softsquared_instagram.src.login.LoginActivity
import org.myapp.softsquared_instagram.src.main.MainActivity
import javax.net.ssl.HandshakeCompletedEvent
import kotlin.concurrent.timer

class StoryActivity : BaseActivity<ActivityStoryBinding>(ActivityStoryBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.black)

        val handler = Handler(Looper.getMainLooper())
        var time = 0
        val timer = timer(period = 30){
            time++
            handler.post{
                binding.activityStoryProgress.progress = time
            }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 3000)
    }
}

