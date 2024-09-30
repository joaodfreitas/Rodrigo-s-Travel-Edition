package com.example.rodrigotravel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    class TripAdapter(private val trips: List<Trip>) : RecyclerView.Adapter<TripAdapter.TripViewHolder>() {

        class TripViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val destinationText: TextView = view.findViewById(R.id.destinationEditText)
            val dateText: TextView = view.findViewById(R.id.dateEditText)
            val amountText: TextView = view.findViewById(R.id.amountEditText)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_trip, parent, false)
            return TripViewHolder(view)
        }

        override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
            val trip = trips[position]
            holder.destinationText.text = trip.destination
            holder.dateText.text = trip.date
            holder.amountText.text = "R$ ${trip.amount}"
        }

        override fun getItemCount() = trips.size
        }