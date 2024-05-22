package com.l0122138.ridlo.responsi1wisatakebumen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122138.ridlo.responsi1wisatakebumen.R
import com.l0122138.ridlo.responsi1wisatakebumen.model.Place

class PlaceAdapter(private val placesList: List<Place>, private val onItemClicked: (Place) -> Unit) : RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {
    class PlaceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.placeImageView)
        val nameTextView: TextView = view.findViewById(R.id.placeNameTextView)
        val locationTextView: TextView = view.findViewById(R.id.placeLocationTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        return PlaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = placesList[position]
        holder.itemView.setOnClickListener {
            onItemClicked(place)
        }
        holder.imageView.setImageResource(place.imageResId)
        holder.nameTextView.text = place.name
        holder.locationTextView.text = place.location
    }

    override fun getItemCount() = placesList.size
}
