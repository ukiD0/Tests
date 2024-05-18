/**
 * This class created for ViewPagerFragment
 * Author Korovkina Valentina
 * Create date 18/05/24
 * */
package com.example.saransk.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saransk.databinding.FragmentViewPagerBinding
import com.example.saransk.presentation.adapters.ViewPagerAdapter


class ViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(inflater,container,false)

        val adapter = ViewPagerAdapter(
            requireActivity(),
            lifecycle
        )
        val sharedPref = requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        val state = sharedPref.getInt("boardState", 0)


        binding.viewpagerID.adapter = adapter
        binding.viewpagerID.currentItem = state


        return binding.root
    }
}