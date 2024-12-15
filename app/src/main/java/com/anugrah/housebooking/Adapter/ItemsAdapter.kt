package com.anugrah.housebooking.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.anugrah.housebooking.Activity.DetailActivity
import com.anugrah.housebooking.Model.ItemsDomain
import com.anugrah.housebooking.databinding.ViewholderItemBinding
import java.text.NumberFormat
import java.util.*

class ItemsAdapter(private var items: ArrayList<ItemsDomain>) :
    RecyclerView.Adapter<ItemsAdapter.Viewholder>() {

    private lateinit var context: Context

    class Viewholder(val binding: ViewholderItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = ViewholderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            titleTxt.text = item.title

            // Format harga menggunakan NumberFormat
            val formattedPrice = NumberFormat.getCurrencyInstance(Locale.US).format(item.price)
            priceTxt.text = formattedPrice

            bedTxt.text = item.bed.toString()
            bathTxt.text = item.bath.toString()

            // Muat gambar menggunakan Glide
            val drawableResourceId = holder.itemView.resources.getIdentifier(
                item.pickPath, "drawable", holder.itemView.context.packageName
            )

            Glide.with(context)
                .load(drawableResourceId)
                .into(pic)

            // Set klik item
            holder.itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("object", item) // Pastikan ItemsDomain mengimplementasikan Serializable/Parcelable
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = items.size
}
