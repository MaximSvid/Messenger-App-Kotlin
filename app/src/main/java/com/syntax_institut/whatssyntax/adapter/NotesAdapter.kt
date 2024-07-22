package com.syntax_institut.whatssyntax.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.databinding.ItemChatBinding
import com.syntax_institut.whatssyntax.databinding.ItemNoteBinding

class NotesAdapter (
    val dataset: List<*>,

    ): RecyclerView.Adapter<NotesAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder (binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.ItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NotesAdapter.ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}