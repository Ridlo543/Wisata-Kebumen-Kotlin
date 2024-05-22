package com.l0122138.ridlo.responsi1wisatakebumen.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragments = arrayListOf<Fragment>()
    private val fragmentTitles = arrayListOf<String>()

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        fragmentTitles.add(title)
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun getPageTitle(position: Int): CharSequence = fragmentTitles[position]
}
