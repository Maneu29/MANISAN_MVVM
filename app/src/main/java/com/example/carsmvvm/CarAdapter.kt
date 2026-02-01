package com.example.carsmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class CarAdapter(private var cars: List<Car> = emptyList()) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    // Add this for smooth loading
    private val requestOptions = RequestOptions()
        .transform(CenterCrop(), RoundedCorners(10))


    class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.carImage)
        val name: TextView = view.findViewById(R.id.carName)
        val brand: TextView = view.findViewById(R.id.carBrand)
        val price: TextView = view.findViewById(R.id.carPrice)
        val electricBadge: TextView = view.findViewById(R.id.electricBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]

        // Set text data (fast)
        holder.name.text = car.name
        holder.brand.text = car.brand
        holder.price.text = car.price

        // Show/hide electric badge
        holder.electricBadge.visibility = if (car.isElectric) View.VISIBLE else View.GONE

        // Load image with GLIDE (smooth loading)
        Glide.with(holder.itemView.context)
            .load(car.image)  // This is our drawable resource ID
            .apply(requestOptions)
            .into(holder.image)
    }

    override fun getItemCount(): Int = cars.size

    fun updateCars(newCars: List<Car>) {
        cars = newCars
        notifyDataSetChanged()
    }
}