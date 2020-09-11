package bw.impurefunctions.gadsleaderboard.models

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import bw.impurefunctions.gadsleaderboard.R
import bw.impurefunctions.gadsleaderboard.activities.LeaderboardActivity

class SubmissionSuccessful : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission_successful)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        window.setLayout((width * .9).toInt(), (height * .6).toInt())

        Handler().postDelayed({
            val homeActivity = Intent(this, LeaderboardActivity::class.java)
            startActivity(homeActivity)
            finish()
        }, SubmissionSuccessful.C_TIME_OUT.toLong())
    }

    companion object {
        private const val C_TIME_OUT = 1000
    }
}