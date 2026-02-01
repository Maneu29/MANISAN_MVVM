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
        setupButton()
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

    }

    private fun setupButton() {
        findViewById<com.google.android.material.button.MaterialButton>(R.id.addButton).setOnClickListener {
            // Add a test car
            val newCar = Car(
                id = 7,
                name = "Test Car",
                brand = "Brand X",
                price = "$99,999",
                image = R.drawable.car1,
                isElectric = true
            )

        }
    }


}