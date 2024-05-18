/**
 * This class created for ViewPagerAdapter
 * Author Korovkina Valentina
 * Create date 18/05/24
 * */
package com.example.saransk.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.saransk.presentation.onboarding.FirstFragment
import com.example.saransk.presentation.onboarding.SecondFragment
import com.example.saransk.presentation.onboarding.ThirdFragment

class ViewPagerAdapter(
    requireActivity: FragmentActivity,
    lifecycle: Lifecycle
    ) : FragmentStateAdapter(requireActivity.supportFragmentManager,lifecycle){

        val queue = ArrayList<Fragment>().apply {
            add(FirstFragment())
            add(SecondFragment())
            add(ThirdFragment())
        }
    override fun getItemCount(): Int {
      return queue.size
    }

    override fun createFragment(position: Int): Fragment {
        return  queue[position]
    }

}

