package com.sohainfotech.findallstay.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sohainfotech.findallstay.R
import com.sohainfotech.findallstay.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    //to use DataBinding
    private var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!

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
        //return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        //initialize views here
        binding.homeFragment.text = "Home Abdul"

        return binding.root
    }

    // Removing the binding reference when not needed is recommended as it avoids memory leak
    override fun onDestroyView() {
        super.onDestroyView()
        //to use DataBinding
        _binding = null
    }
}