package com.l0122138.ridlo.responsi1wisatakebumen.ui.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.l0122138.ridlo.responsi1wisatakebumen.databinding.FragmentDetailDestinationBinding

class DetailDestinationFragment : Fragment() {
    private var _binding: FragmentDetailDestinationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailDestinationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { args ->
            val safeArgs = DetailDestinationFragmentArgs.fromBundle(args)
            val imageResId = safeArgs.imageResId
            val name = safeArgs.name
            val location = safeArgs.location
            val description = safeArgs.description

            if (imageResId != 0) {
                binding.detailImage.setImageResource(imageResId)
            }
            binding.detailTitle.text = name
            binding.detailLocation.text = location
            binding.detailDescription.text = description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
