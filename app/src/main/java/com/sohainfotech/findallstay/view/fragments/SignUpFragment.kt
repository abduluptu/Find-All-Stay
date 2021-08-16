package com.sohainfotech.findallstay.view.fragments

import android.app.Application
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.sohainfotech.findallstay.databinding.FragmentSignUpBinding
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.sohainfotech.findallstay.container.BaseApplication
import com.sohainfotech.findallstay.container.Component
import com.sohainfotech.findallstay.model.LoginRegisterResponse

class SignUpFragment : Fragment() {
    //to use DataBinding
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val component = Component()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //to use DataBinding
        //return inflater.inflate(R.layout.fragment_sign_up, container, false)
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        //initialize views here
        // binding.loginFragment.text = "Hello Login"
        initializeViews()
        registerUser()

        return binding.root
    }

    private fun initializeViews() {
        binding.txtHello.text = resources.getString(com.sohainfotech.findallstay.R.string.hello)
        binding.txtsignUpInfo.text =
            resources.getString(com.sohainfotech.findallstay.R.string.sign_up_to_get_fas)

        binding.textSignIn.setOnClickListener {
            val signInFragment = SignInFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(
                com.sohainfotech.findallstay.R.id.flFragment,
                signInFragment
            ) // give your fragment container id in first parameter
            transaction.addToBackStack(null) // if written, this transaction will be added to backstack
            transaction.commit()

        }
    }

    private fun registerUser() {

        //component.loginRegisterViewModel.registerUser()
        binding.apply {

            signup.setOnClickListener {

                lifecycleScope.launchWhenStarted {

                    //----------------
                    val deviceId: String = ""
                    //pass actual device id

                    /*if (!TextUtils.isEmpty(username.text.toString()) && !TextUtils.isEmpty(
                            mobileNumber.text.toString()
                        )
                        && !TextUtils.isEmpty(emailId.text.toString()) && !TextUtils.isEmpty(
                            password.text.toString()
                        )
                    ) {

                        try {
                            component.loginRegisterViewModel.registerUser(
                                username.text.toString().trim(),
                                mobileNumber.text.toString().trim(),
                                emailId.text.toString().trim(),
                                password.text.toString().trim(),
                                deviceId
                            )
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }

                        getLoginRegisterResponse()


                    } else {
                        Toast.makeText(context, "please fill all the fields", Toast.LENGTH_SHORT)
                            .show()
                    }*/
                }

                    //just for test--------------
                component.loginRegisterViewModel.postForm(3, 1, "Sample Post Form", "Sample Description")

                component.loginRegisterViewModel.getTestResponse().observe(requireActivity(), Observer {
                    val result = it.body()
                    val message = it.message()
                    val error = it.code()

                    if (it.isSuccessful) {

                        Log.d("Success", result.toString())
                        Log.d("Message", message.toString())
                        Log.d("Error", error.toString())
                    } else {
                        //Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                    }
                })

            }
        }
    }

    fun getLoginRegisterResponse() {
        component.loginRegisterViewModel.getLoginRegisterResponse().observe(
            requireActivity(),
            Observer {
                val result = it.body()
                val message = it.message()
                val error = it.code()

                if (it.isSuccessful) {

                    Log.d("Success", result.toString())
                    Log.d("Message", message.toString())
                    Log.d("Error", error.toString())
                } else {
                    //Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                }
            })

    }


    // Removing the binding reference when not needed is recommended as it avoids memory leak
    override fun onDestroyView() {
        super.onDestroyView()
        //to use DataBinding
        _binding = null
    }

}
