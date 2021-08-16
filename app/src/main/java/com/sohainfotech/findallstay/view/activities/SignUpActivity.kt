package com.sohainfotech.findallstay.view.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.google.android.material.textfield.TextInputEditText
import com.sohainfotech.findallstay.R
import com.sohainfotech.findallstay.databinding.ActivitySignUpBinding

//-----------------Not in use-----------
class SignUpActivity : AppCompatActivity() {
    //to use DataBinding
    private lateinit var binding: ActivitySignUpBinding

   // private var signup: Button? = null
   // private var username: TextInputEditText? = null
    //private var password: TextInputEditText? = null
    //private var passwordagain: TextInputEditText? = null
    private var progressDialog: ProgressDialog? = null

    //private var toolbar: Toolbar? = null
    //private var toolbarText: TextView? = null

    private lateinit var toolbar: Toolbar
    private lateinit var toolbarText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //to use DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up) as ActivitySignUpBinding
        //setContentView(R.layout.activity_sign_up)

        /*toolbar = findViewById(R.id.toolbar_signup)
        toolbarText = findViewById(R.id.toolbarText)
        toolbar.title = resources.getString(R.string.sign_up)
        setSupportActionBar(toolbar)*/

        binding.toolbarSignup.title = resources.getString(R.string.sign_up)
        setSupportActionBar(binding.toolbarSignup)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // sets onClickListener on the navigation icon of the toolbar
        binding.toolbarSignup.setNavigationOnClickListener(View.OnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

        })

        progressDialog = ProgressDialog(this)

        //back = findViewById(R.id.back)
        //signup = findViewById(R.id.signup)
        //username = findViewById(R.id.username)
        //password = findViewById(R.id.password)
       // passwordagain = findViewById(R.id.passwordagain)

       // signup?.setOnClickListener {
        binding.signup.setOnClickListener {
            /*if (password?.text.toString() == passwordagain?.text.toString() && !TextUtils.isEmpty(username?.text.toString()))
                signup(username?.text.toString(), password?.text.toString());*/
           /* else
                Toast.makeText(
                    this,
                    "Make sure that the values you entered are correct.",
                    Toast.LENGTH_SHORT
                ).show();*/
        }

        /*back?.setOnClickListener {
            finish()
        }*/
    }

    fun signup(username: String, password: String) {
        progressDialog?.show()

       /* val user = ParseUser()
        // Set the user's username and password, which can be obtained by a forms
        user.setUsername(username);
        user.setPassword(password);
        user.signUpInBackground(SignUpCallback() {
            progressDialog?.dismiss()
            if (it == null) {
                showAlert("Successful Sign Up!", "Welcome " + username + " !");
            } else {
                ParseUser.logOut();
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show();
            }
        });*/

        //Add by Abdul
        showAlert("Successful Sign Up!", "Welcome " + username + " !");
    }

    private fun showAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, which ->
                dialog.cancel()
                // don't forget to change the line below with the names of your Activities
                val intent = Intent(this, LogoutActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        val ok = builder.create()
        ok.show()
    }

}