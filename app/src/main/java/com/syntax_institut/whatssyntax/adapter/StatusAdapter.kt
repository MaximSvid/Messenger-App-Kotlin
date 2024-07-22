package com.syntax_institut.whatssyntax.adapter

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.databinding.ItemContactBinding
import com.syntax_institut.whatssyntax.databinding.ItemNoteBinding
import com.syntax_institut.whatssyntax.databinding.ItemStatusBinding
import com.syntax_institut.whatssyntax.model.Chats
import com.syntax_institut.whatssyntax.model.Contact

class StatusAdapter (
    var dataset: List<Chats>,
    val viewModel: MainViewModel
    ): RecyclerView.Adapter<StatusAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder (binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusAdapter.ItemViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatusAdapter.ItemViewHolder, position: Int) {
        dataset = dataset.sortedBy { it.contact.status == null }
        val items = dataset[position]

        holder.binding.tvContactName.text = items.contact.name

        val imageUrl = "http://81.169.201.230:8080" + items.contact.image

        if (items.contact.status == null) {
            holder.binding.ivContactImage.load(imageUrl) {
                val colorMatrix = ColorMatrix()
                colorMatrix.setSaturation(0f)
                holder.binding.ivContactImage.colorFilter = ColorMatrixColorFilter(colorMatrix)
            }
        } else {
            holder.binding.ivContactImage.load(imageUrl)
        }


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}