/**
 * This class created for ThirdFragment
 * Author Korovkina Valentina
 * Create date 18/05/24
 * */
package com.example.saransk.presentation.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.saransk.R
import com.example.saransk.databinding.FragmentThirdBinding
import java.text.FieldPosition


class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater,container,false)

        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_signInFragment)
            onBoardingFinished()
        }

        return binding.root
    }
     private fun onBoardingFinished(){
         val sharedPref = requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
         val editor = sharedPref.edit()
         editor.putBoolean("Finished",true)
         editor.apply()
     }
}