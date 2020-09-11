package bw.impurefunctions.gadsleaderboard.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import bw.impurefunctions.gadsleaderboard.BuildConfig
import bw.impurefunctions.gadsleaderboard.R
import kotlinx.android.synthetic.main.activity_project_submission.*

class ProjectSubmissionActivity : AppCompatActivity() {
    private lateinit var firstName: EditText
   private lateinit var lastName: EditText
    private lateinit var emailAddress: EditText
    private lateinit var githubLink: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_submission)
        if (BuildConfig.DEBUG && supportActionBar == null) {
            error("Assertion failed")
        }
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        firstName = first_name
        lastName = last_name
        emailAddress = email_address
        githubLink = github_link
        val submitProject: Button = submit_project
        submitProject.setOnClickListener {
            val fName: String = first_name.text.toString()
            val lName: String = last_name.text.toString()
            val email: String = email_address.text.toString()
            val gitHubLink: String = github_link.text.toString()
            val intent = Intent(this@ProjectSubmissionActivity, ConfirmationActivity::class.java)
            intent.putExtra("fName", fName)
            intent.putExtra("lName", lName)
            intent.putExtra("email", email)
            intent.putExtra("gitHubLink", gitHubLink)
            Log.d("Assert", "Testing: $fName, $lName, $email")
            startActivity(intent)
        }
    }

    //To handle back pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Respond to the action bar's Up/Home button
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}