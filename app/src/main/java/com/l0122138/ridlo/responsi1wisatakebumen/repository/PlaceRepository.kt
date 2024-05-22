package com.l0122138.ridlo.responsi1wisatakebumen.repository

import android.content.Context
import com.l0122138.ridlo.responsi1wisatakebumen.R
import com.l0122138.ridlo.responsi1wisatakebumen.model.Place

object PlaceRepository {
    fun getNaturalPlaces(context: Context): List<Place> {
        return getPlaces(context, R.array.natural_place_names, R.array.natural_place_images, R.array.natural_place_locations, R.array.natural_place_description)
    }

    fun getNonNaturalPlaces(context: Context): List<Place> {
        return getPlaces(context, R.array.non_natural_place_names, R.array.non_natural_place_images, R.array.non_natural_place_locations, R.array.non_natural_place_description)
    }

    private fun getPlaces(context: Context, namesResId: Int, imagesResId: Int, locationsResId: Int, descriptionsResId: Int): List<Place> {
        val resources = context.resources
        val names = resources.getStringArray(namesResId)
        val images = resources.obtainTypedArray(imagesResId)
        val locations = resources.getStringArray(locationsResId)
        val descriptions = resources.getStringArray(descriptionsResId)

        return names.indices.map { index ->
            Place(
                images.getResourceId(index, -1),
                names[index],
                locations[index],
                descriptions[index]
            )
        }.also {
            images.recycle()
        }
    }
}