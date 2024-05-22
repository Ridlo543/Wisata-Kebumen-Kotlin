package com.l0122138.ridlo.responsi1wisatakebumen.ui.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.l0122138.ridlo.responsi1wisatakebumen.adapter.PlaceAdapter
import com.l0122138.ridlo.responsi1wisatakebumen.databinding.FragmentNaturalPlaceListBinding
import com.l0122138.ridlo.responsi1wisatakebumen.repository.PlaceRepository

class NaturalPlaceListFragment : Fragment() {
    private var _binding: FragmentNaturalPlaceListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNaturalPlaceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val placesList = PlaceRepository.getNaturalPlaces(requireContext())

        binding.placesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PlaceAdapter(placesList) { place ->
                val action = DestinationsFragmentDirections.actionGlobalToDetailDestinationFragment(
                    place.imageResId, place.name, place.location, place.description
                )
                findNavController().navigate(action)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = NaturalPlaceListFragment()
    }
}
