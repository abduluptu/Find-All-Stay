package com.sohainfotech.findallstay.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sohainfotech.findallstay.databinding.FragmentSignInBinding
import android.R
import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class SignInFragment : Fragment() {
    //to use DataBinding
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

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
        //return inflater.inflate(R.layout.fragment_sign_in, container, false)
        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        //initialize views here
        // binding.loginFragment.text = "Hello Login"

        initializeViews()

        return binding.root
    }

    private fun initializeViews() {
        binding.txtWelcomeBack.text =
            resources.getString(com.sohainfotech.findallstay.R.string.welcome_back)
        binding.txtsignInInfo.text =
            resources.getString(com.sohainfotech.findallstay.R.string.sign_into_your_fas_account)

        binding.textSignup.setOnClickListener {

            val signUpFragment = SignUpFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(
                com.sohainfotech.findallstay.R.id.flFragment,
                signUpFragment
            ) // give your fragment container id in first parameter
             transaction.addToBackStack(null) // if written, this transaction will be added to backstack
            transaction.commit()

        }
    }

    // Removing the binding reference when not needed is recommended as it avoids memory leak
    override fun onDestroyView() {
        super.onDestroyView()
        //to use DataBinding
        _binding = null
    }

}