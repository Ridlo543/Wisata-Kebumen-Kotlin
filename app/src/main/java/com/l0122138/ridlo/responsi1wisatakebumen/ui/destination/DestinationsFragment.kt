package com.l0122138.ridlo.responsi1wisatakebumen.ui.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.l0122138.ridlo.responsi1wisatakebumen.R
import com.l0122138.ridlo.responsi1wisatakebumen.adapter.ViewPagerAdapter
import com.l0122138.ridlo.responsi1wisatakebumen.databinding.FragmentDestinationsBinding

class DestinationsFragment : Fragment() {
    private lateinit var binding: FragmentDestinationsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDestinationsBinding.inflate(inflater, container, false)
        setupViewPager()
        return binding.root
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(this)
        adapter.addFragment(NaturalPlaceListFragment.newInstance(), "Wisata Alam")
        adapter.addFragment(NonNaturalPlaceListFragment.newInstance(), "Wisata Non Alam")

        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
            when (position) {
                0 -> tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.baseline_grass_24)
                1 -> tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.baseline_account_balance_24)
            }
        }.attach()
    }
}
