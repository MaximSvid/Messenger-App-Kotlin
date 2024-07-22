package com.syntax_institut.whatssyntax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.whatssyntax.databinding.ItemContactBinding
import com.syntax_institut.whatssyntax.databinding.ItemNoteBinding
import com.syntax_institut.whatssyntax.databinding.ItemStatusBinding
import com.syntax_institut.whatssyntax.model.Chats

class StatusAdapter (
    val dataset: List<Chats>,

    ): RecyclerView.Adapter<StatusAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder (binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusAdapter.ItemViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatusAdapter.ItemViewHolder, position: Int) {
        val items = dataset[position]

        holder.binding.tvContactName.text = items.contact.name

        val imageUrl = items.contact.image
        holder.binding.ivContactImage.load(items.contact.image)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}