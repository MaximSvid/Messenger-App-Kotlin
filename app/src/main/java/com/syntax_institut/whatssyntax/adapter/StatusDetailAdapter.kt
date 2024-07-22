package com.syntax_institut.whatssyntax.adapter

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.databinding.ItemContactBinding
import com.syntax_institut.whatssyntax.databinding.ItemStatusBinding
import com.syntax_institut.whatssyntax.model.Contact
import com.syntax_institut.whatssyntax.model.Status
import com.syntax_institut.whatssyntax.ui.StatusFragmentDirections

class StatusDetailAdapter (
    var dataset: List<Status>,
    val viewModel: MainViewModel
): RecyclerView.Adapter<StatusDetailAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemStatusBinding) : RecyclerView.ViewHolder (binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusDetailAdapter.ItemViewHolder {
        val binding = ItemStatusBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatusDetailAdapter.ItemViewHolder, position: Int) {
        val items = dataset[position]

        val url = "http://81.169.201.230:8080" + items.images

        holder.binding.ivStatusDetail.load(url)




    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}