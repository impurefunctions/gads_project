package bw.impurefunctions.gadsleaderboard.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import bw.impurefunctions.gadsleaderboard.R
import bw.impurefunctions.gadsleaderboard.models.SubmissionFailedDialog
import bw.impurefunctions.gadsleaderboard.models.SubmissionSuccessful
import bw.impurefunctions.gadsleaderboard.services.SendToGoogleForms
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfirmationActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        window.setLayout((width * .9).toInt(), (height * .6).toInt())


        val intent = intent



        val fName = intent.getStringExtra("fName")
       val  lName = intent.getStringExtra("lName")
       val email = intent.getStringExtra("email")
        val githubLink = intent.getStringExtra("githubLink")

        val builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()


        val submitToGoogleForms = retrofit.create(SendToGoogleForms::class.java)
        val submit = findViewById<Button>(R.id.submit_project)
        submit.setOnClickListener {
            val submitProjectRequest = submitToGoogleForms.submitProject(fName, lName, githubLink, email)
            submitProjectRequest!!.enqueue(object : Callback<Void?> {
                override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                    Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()
                    finish()
                    startActivity(Intent(this@ConfirmationActivity, SubmissionSuccessful::class.java))
                }

                override fun onFailure(call: Call<Void?>, t: Throwable) {
                    Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    finish()
                    startActivity(Intent(this@ConfirmationActivity, SubmissionFailedDialog::class.java))

                }
            })
        }
        val cancel = findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener { view: View? -> finish() }
    }

    private fun failureDialog() {

    }

    private fun successDialog() {

    }

    companion object {
        private const val BASE_URL = "https://docs.google.com/forms/d/e/"
    }
}