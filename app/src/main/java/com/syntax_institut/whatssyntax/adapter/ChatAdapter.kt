package com.syntax_institut.whatssyntax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.data.remote.BASE_URL
import com.syntax_institut.whatssyntax.databinding.ItemChatBinding
import com.syntax_institut.whatssyntax.model.Chats
import com.syntax_institut.whatssyntax.ui.ChatsFragmentDirections

//import com.syntax_institut.whatssyntax.ui.ChatsFragmentDirections

class ChatAdapter(
    private val dataset: List<Chats>,
    private val viewModel: MainViewModel
    ): RecyclerView.Adapter<ChatAdapter.ItemViewHolder>() {

        inner class ItemViewHolder(val binding: ItemChatBinding) : RecyclerView.ViewHolder (binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ItemViewHolder {
        val binding = ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.tvChatContactName.text = item.contact.name

        val imageUrl = BASE_URL + item.contact.image
        holder.binding.ivChatContactImage.load(imageUrl)

        holder.binding.tvChatLastMess.text = item.lastMessage.text.toString()

        holder.binding.cvChat.setOnClickListener {
            viewModel.getCurrentCath(item)
            holder.itemView.findNavController().navigate(ChatsFragmentDirections.actionChatsFragmentToChatDetailFragment2())

        }



    }

    override fun getItemCount(): Int {
      return  dataset.size
    }
}