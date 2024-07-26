package com.syntax_institut.whatssyntax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.databinding.ItemChatBinding
import com.syntax_institut.whatssyntax.databinding.ItemNoteBinding
import com.syntax_institut.whatssyntax.model.NotesData
import com.syntax_institut.whatssyntax.ui.NotesFragmentDirections

class NotesAdapter (
    private val dataset: List<NotesData>,
    private val viewModel: MainViewModel

    ): RecyclerView.Adapter<NotesAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder (binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.ItemViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesAdapter.ItemViewHolder, position: Int) {
        val notes = dataset[position]
        val binding = holder.binding

        binding.tvNoteName.text = notes.name
        binding.tvNoteText.text = notes.text

        binding.btnDelete.setOnClickListener {
            viewModel.deleteNote(notes)
        }

        binding.cvNote.setOnClickListener {
            viewModel.selectedNote(notes)

            holder.itemView.findNavController().navigate(NotesFragmentDirections.actionNotesFragmentToNoteDetailFragment())
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}