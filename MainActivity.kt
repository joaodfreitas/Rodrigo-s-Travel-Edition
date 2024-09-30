package com.example.rodrigotravel

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var tripList: RecyclerView
    private lateinit var totalSpentText: TextView
    private lateinit var destinationInput: EditText
    private lateinit var dateInput: EditText
    private lateinit var amountInput: EditText
    private lateinit var addTripButton: Button

    private val trips = mutableListOf<Trip>()
    private var totalSpent = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        totalSpentText = findViewById(R.id.totalSpentTextView)
        destinationInput = findViewById(R.id.destinationEditText)
        dateInput = findViewById(R.id.dateEditText)
        amountInput = findViewById(R.id.amountEditText)
        addTripButton = findViewById(R.id.addTripButton)
        tripList = findViewById(R.id.tripRecyclerView)

        tripList.layoutManager = LinearLayoutManager(this)
        tripList.adapter = TripAdapter(trips)

        addTripButton.setOnClickListener {
            addTrip()
        }
    }

    private fun addTrip() {
        val destination = destinationInput.text.toString()
        val date = dateInput.text.toString()
        val amount = amountInput.text.toString().toDoubleOrNull() ?: return

        val trip = Trip(destination, date, amount)
        trips.add(trip)
        totalSpent += amount
        updateUI()
    }

    private fun updateUI() {
        totalSpentText.text = "Total gasto: R$ $totalSpent"
        tripList.adapter?.notifyDataSetChanged()
        clearInputs()
    }

    private fun clearInputs() {
        destinationInput.text.clear()
        dateInput.text.clear()
        amountInput.text.clear()
    }
}