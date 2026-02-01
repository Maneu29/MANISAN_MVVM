package com.example.carsmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarViewModel : ViewModel() {

    // Our list of cars
    private val _cars = MutableLiveData<List<Car>>()
    val cars: LiveData<List<Car>> get() = _cars

    init {
        // Load cars when ViewModel is created
        loadCars()
    }

    private fun loadCars() {
        //car list
        val carsList = listOf(
            Car(1, "Model S Plaid", "Tesla", "$129,990", R.drawable.car1, true),
            Car(2, "Taycan Turbo", "Porsche", "$189,900", R.drawable.car2, true),
            Car(3, "Revuelto", "Lamborghini", "$608,358", R.drawable.car3, false),
            Car(4, "SF90 Stradale", "Ferrari", "$625,000", R.drawable.car4, false),
            Car(5, "i7 M70", "BMW", "$170,000", R.drawable.car5, true),
            Car(6, "EQS", "Mercedes", "$105,000", R.drawable.car6, true)
        )

        _cars.value = carsList
    }
}