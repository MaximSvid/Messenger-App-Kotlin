package com.syntax_institut.whatssyntax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.databinding.ItemChatBinding
import com.syntax_institut.whatssyntax.databinding.ItemChatInBinding
import com.syntax_institut.whatssyntax.databinding.ItemChatOutBinding
import com.syntax_institut.whatssyntax.model.Chats

class ChatDetailAdapter(
    private val dataset: List<Chats>,
    private val viewModel: MainViewModel
    ) : RecyclerView.Adapter<ViewHolder>() {

    inner class IncomingViewHolder(val incomingBinding: ItemChatInBinding) :
        ViewHolder(incomingBinding.root)

    inner class OutgoingViewHolder(val outgoingBinding: ItemChatOutBinding) :
        ViewHolder(outgoingBinding.root)

    private val incomingType = 1
    private val outgoingType = 2

    override fun getItemViewType(position: Int): Int {
        val message = dataset[position]

        if (message.lastMessage.incoming) {
            return incomingType
        }
        return outgoingType
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        if (viewType == incomingType) {
            val incomingBinding = ItemChatInBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return IncomingViewHolder(incomingBinding)
        }
        val outgoingBinding = ItemChatOutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OutgoingViewHolder(outgoingBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = dataset[position]

        if (holder is IncomingViewHolder){
            holder.incomingBinding.tvMessageIn.text = message.lastMessage.text
        } else if (holder is OutgoingViewHolder) {
            holder.outgoingBinding.tvMessageOut.text = message.lastMessage.text
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}