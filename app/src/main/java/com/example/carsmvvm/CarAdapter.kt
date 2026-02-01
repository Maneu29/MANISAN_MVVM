package com.example.carsmvvm

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(private var cars: List<Car> = emptyList()) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    // ViewHolder holds one item view
    class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.carImage)
        val name: TextView = view.findViewById(R.id.carName)
        val brand: TextView = view.findViewById(R.id.carBrand)
        val price: TextView = view.findViewById(R.id.carPrice)
        val electricBadge: TextView = view.findViewById(R.id.electricBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        // Create view from XML
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]

        // Set data to views
        holder.name.text = car.name
        holder.brand.text = car.brand
        holder.price.text = car.price

        // Set image
        holder.image.setImageResource(car.image)

        // Show electric badge if electric
        if (car.isElectric) {
            holder.electricBadge.visibility = View.VISIBLE
        } else {
            holder.electricBadge.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = cars.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateCars(cars: List<Car>) {
        this.cars = cars
        notifyDataSetChanged()
    }
}