package com.l0122138.ridlo.responsi1wisatakebumen.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.l0122138.ridlo.responsi1wisatakebumen.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = arrayListOf(
            SlideModel(R.drawable.bukit_banda, "Bukit Banda"),
            SlideModel(R.drawable.bukit_pranji, "Bukit Pranji"),
            SlideModel(R.drawable.benteng_vanderwijck, "Benteng Vanderwijck"),
            SlideModel(R.drawable.padegolan, "Padegolan"),
            SlideModel(R.drawable.pantai_menganti, "Pantai Menganti"),
            SlideModel(R.drawable.pantai_pecaron, "Pantai Pecaron")
        )

        val imageSlider = view.findViewById<com.denzcoskun.imageslider.ImageSlider>(R.id.imageSlider)
        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
    }
}
