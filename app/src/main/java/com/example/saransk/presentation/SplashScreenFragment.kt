package com.example.saransk.presentation

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.saransk.R
import com.example.saransk.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment() {
    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashScreenBinding.inflate(inflater,container,false)

        Handler(Looper.getMainLooper()).postDelayed({
            onBoardingFinished()
        },2500)


        return binding.root
    }
    fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        val isFinished = sharedPref.getBoolean("Finished", false)
        if (isFinished){
            findNavController().navigate(R.id.action_splashScreenFragment_to_signInFragment)
        }else{
            findNavController().navigate(R.id.action_splashScreenFragment_to_viewPagerFragment)
        }
    }

}