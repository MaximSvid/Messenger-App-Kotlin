package com.syntax_institut.whatssyntax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.whatssyntax.databinding.ItemChatBinding
import com.syntax_institut.whatssyntax.model.Chats
import com.syntax_institut.whatssyntax.model.Contact

class ChatAdapter(
    val dataset: List<Chats>,

    ): RecyclerView.Adapter<ChatAdapter.ItemViewHolder>() {

        inner class ItemViewHolder(val binding: ItemChatBinding) : RecyclerView.ViewHolder (binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ItemViewHolder {
        val binding = ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.tvChatContactName.text = item.contact.name
        holder.binding.ivChatContactImage.load(item.contact.image)

        holder.binding.tvChatLastMess.text = item.contact.status?.toString() ?: "Unknown" //? --



    }

    override fun getItemCount(): Int {
      return  dataset.size
    }
}