package com.sohainfotech.findallstay.view.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.google.android.material.textfield.TextInputEditText
import com.sohainfotech.findallstay.R
import com.sohainfotech.findallstay.databinding.ActivityLoginBinding
import com.sohainfotech.findallstay.databinding.ActivityMainBinding

//-----------------Not in use-----------
class LoginActivity : AppCompatActivity() {
    //to use DataBinding
    private lateinit var binding: ActivityLoginBinding

    private var username: TextInputEditText? = null
    private var password: TextInputEditText? = null
    private var login: Button? = null
    //private var navigatesignup: Button? = null
    private var signupText: TextView? = null
    private var progressDialog: ProgressDialog? = null

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //to use DataBinding
        //setContentView(R.layout.activity_login)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login) as ActivityLoginBinding

        //toolbar = findViewById(R.id.toolbar_login)
        //setSupportActionBar(toolbar)
        //home navigation
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setSupportActionBar(binding.toolbarLogin)

        progressDialog = ProgressDialog(this@LoginActivity)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        //navigatesignup = findViewById(R.id.navigatesignup)

        signupText = findViewById(R.id.textSignup)

        login?.setOnClickListener(View.OnClickListener {
            login(
                username?.text.toString(),
                password?.text.toString()
            )
        })

        /*navigatesignup?.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    SignUpActivity::class.java
                )
            )
        })*/

        signupText?.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    SignUpActivity::class.java
                )
            )
        }

    }

    fun login(username: String, password: String) {
        progressDialog?.show()
       /* ParseUser.logInInBackground(username,password) { parseUser: ParseUser?, parseException: ParseException? ->
            progressDialog?.dismiss()
            if (parseUser != null) {
                showAlert("Successful Login", "Welcome back " + username + " !")
            } else {
                ParseUser.logOut()
                if (parseException != null) {
                    Toast.makeText(this, parseException.message, Toast.LENGTH_LONG).show()
                }
            }
        }*/

        //Add by Abdul
        showAlert("Successful Login", "Welcome back " + username + " !")
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