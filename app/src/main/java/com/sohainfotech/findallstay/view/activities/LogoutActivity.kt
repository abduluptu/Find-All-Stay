package com.sohainfotech.findallstay.view.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.sohainfotech.findallstay.R
import com.sohainfotech.findallstay.databinding.ActivityLogoutBinding

class LogoutActivity : AppCompatActivity() {
    //to use DataBinding
    private lateinit var binding: ActivityLogoutBinding

    //var logout: Button? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //to use DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_logout) as ActivityLogoutBinding
        //setContentView(R.layout.activity_logout)

        //logout = findViewById(R.id.logout)
        progressDialog = ProgressDialog(this)

        //logout?.setOnClickListener {
        binding.logout.setOnClickListener {
            progressDialog!!.show()

            // logging out of Parse
           /* ParseUser.logOutInBackground { e: ParseException? ->
                progressDialog!!.dismiss()
                if (e == null)
                    showAlert("So, you're going...", "Ok...Bye-bye then")
            }*/


            //Add by Abdul
            showAlert("So, you're going...", "Ok...Bye-bye then")
        }
    }

    private fun showAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, which ->
                dialog.cancel()
                // don't forget to change the line below with the names of your Activities
                val intent = Intent(this, LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        val ok = builder.create()
        ok.show()
    }
}