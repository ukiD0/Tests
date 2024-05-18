/**
 * This class created for SecondFragment
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
import androidx.viewpager2.widget.ViewPager2
import com.example.saransk.R
import com.example.saransk.databinding.FragmentSecondBinding
import java.text.FieldPosition


class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewpagerID)

        binding.next.setOnClickListener {
            viewPager.currentItem = 2
            saveState(2)
        }

        return binding.root
    }
    private fun saveState(position: Int){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        sharedPref.edit().apply{
            sharedPref.getInt("boardState",position)
            apply()
        }
    }

}