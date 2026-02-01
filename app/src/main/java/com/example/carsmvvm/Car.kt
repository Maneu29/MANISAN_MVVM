package com.example.carsmvvm

// Simple Car data class
data class Car(
    val id: Int,
    val name: String,
    val brand: String,
    val price: String,
    val image: Int,
    val isElectric: Boolean = false
)