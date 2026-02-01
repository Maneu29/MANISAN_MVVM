package com.example.carsmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var carViewModel: CarViewModel
    private lateinit var carAdapter: CarAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        setupViewModel()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        carAdapter = CarAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = carAdapter
        }
    }

    private fun setupViewModel() {
        carViewModel = ViewModelProvider(this)[CarViewModel::class.java]

        // Watch for car data changes
        carViewModel.cars.observe(this) { cars ->
            carAdapter.updateCars(cars)
            updateCarCount(cars.size)
        }
    }

    private fun updateCarCount(count: Int) {
        findViewById<android.widget.TextView>(R.id.carCount).text = getString(R.string.car_count, count)
    }
}