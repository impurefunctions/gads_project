package bw.impurefunctions.gadsleaderboard.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import bw.impurefunctions.gadsleaderboard.R
import bw.impurefunctions.gadsleaderboard.activities.SplashScreenActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val homeActivity = Intent(this@SplashScreenActivity, LeaderboardActivity::class.java)
            startActivity(homeActivity)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {
        private const val SPLASH_TIME_OUT = 2000
    }
}