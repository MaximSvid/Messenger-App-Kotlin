package com.syntax_institut.whatssyntax.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.databinding.ItemCallBinding
import com.syntax_institut.whatssyntax.databinding.ItemChatBinding

class CallAdapter (
    val dataset: List<*>,

    ): RecyclerView.Adapter<CallAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemCallBinding) : RecyclerView.ViewHolder (binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallAdapter.ItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CallAdapter.ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}